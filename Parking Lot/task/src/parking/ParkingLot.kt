package parking

const val EMPTY_SPOT = ""

class BadSpotNumberException(m: String) : RuntimeException(m)

class ParkingLot(capacity: Int) {
    private var parking = MutableList(capacity) { EMPTY_SPOT }

    fun park(regNumber: String, color: String): Int {
        return if (parking.contains(EMPTY_SPOT)) {
            val spot = parking.indexOf(EMPTY_SPOT)
            parking[spot] = "$regNumber $color"
            spot + 1
        } else {
            -1
        }
    }

    fun leave(spotNumber: Int): Boolean {
        if (spotNumber > parking.count()) {
            throw BadSpotNumberException("There are no spot number $spotNumber in the parking!")
        }
        return if (parking[spotNumber - 1] == EMPTY_SPOT) {
            false
        } else {
            parking[spotNumber - 1] = EMPTY_SPOT
            true
        }
    }

    fun getStatus(): String {
        return if (parking.count { s -> s != EMPTY_SPOT } == 0) {
            "Parking lot is empty."
        } else {
            parking.filter { s -> s != EMPTY_SPOT }
                .joinToString("\n") { "${parking.indexOf(it) + 1} $it" }
        }
    }

    fun getSpotOrRegByColor(color: String, getReg: Boolean): String {
        return if (parking.count { s -> s.contains(color, true) } == 0) {
            "No cars with color $color were found."
        } else {
            parking.filter { s -> s.contains(color, true) }
                .joinToString(", ") {
                    if (getReg) {
                        it.substringBefore(" ")
                    } else "${parking.indexOf(it) + 1}"
                }
        }
    }

    fun getSpotByReg(regNumber: String): Int =
        parking.indexOfFirst { s -> s.contains(regNumber) } + 1

}

