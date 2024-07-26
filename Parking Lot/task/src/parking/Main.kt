package parking

import java.util.Scanner

const val CREATE_CMD = "create"
const val PARK_CMD = "park"
const val LEAVE_CMD = "leave"
const val EXIT_CMD = "exit"
const val STATUS_CMD = "status"
const val REG_BY_COLOR = "reg_by_color"
const val SPOT_BY_COLOR = "spot_by_color"
const val SPOT_BY_REG = "spot_by_reg"
const val GET_REG = true

//const val PATTERN = """(?<cmd>\w+)(${'$'}|(\s((?<number>\d+)|((?<regNumber>.*)\s(?<color>\w+)))))"""
const val PATTERN =
    """(?<cmd>^\w+)(${'$'}|(\s((?<number>\d+)|((?<regNumber>.*)\s(?<color>\w+))|(?<getByParam>.*${'$'}))))"""

fun main() {

    var userParking: ParkingLot? = null
    val scanner = Scanner(System.`in`)
    var line = scanner.nextLine()

    while (line != EXIT_CMD) {
        PATTERN.toRegex().matchEntire(line)!!.groups.let {
            if (it["cmd"]!!.value == CREATE_CMD) {
                val num = it["number"]!!.value.toInt()
                userParking = ParkingLot(num)
                println("Created a parking lot with $num spots.")
            } else {
                if (userParking != null) {
                    when (it["cmd"]!!.value) {
                        PARK_CMD -> userParking!!.parkCar(
                            it["regNumber"]!!.value.trim(),
                            it["color"]!!.value
                        )

                        LEAVE_CMD -> userParking!!.leaveLot(it["number"]!!.value.toInt())
                        STATUS_CMD -> println(userParking!!.getStatus())
                        REG_BY_COLOR -> println(
                            userParking!!.getSpotOrRegByColor(
                                it["getByParam"]!!.value,
                                GET_REG
                            )
                        )

                        SPOT_BY_COLOR -> println(
                            userParking!!.getSpotOrRegByColor(
                                it["getByParam"]!!.value,
                                GET_REG.not()
                            )
                        )

                        SPOT_BY_REG -> userParking!!.getSpotNumberByReg(it["getByParam"]!!.value)
                    }
                } else {
                    println("Sorry, a parking lot has not been created.")
                }
            }
        }

        line = scanner.nextLine()
    }
}

fun ParkingLot.parkCar(regNumber: String, color: String) {
    val spot = this.park(regNumber, color)
    println(
        if (spot > 0) "$color car parked in spot $spot." else "Sorry, the parking lot is full."
    )
}

fun ParkingLot.leaveLot(spot: Int) {
    try {
        println(
            if (this.leave(spot)) "Spot $spot is free." else "There is no car in spot $spot."
        )
    } catch (e: BadSpotNumberException) {
        println(e.message)
    }
}

fun ParkingLot.getSpotNumberByReg(regNumber: String) {
    val spot = this.getSpotByReg(regNumber)
    println(
        if (spot > 0) "$spot" else "No cars with registration number $regNumber were found."
    )
}

