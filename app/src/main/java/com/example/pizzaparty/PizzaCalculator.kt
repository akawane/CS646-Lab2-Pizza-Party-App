import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * PizzaCalculator class responsible for calculating the number of pizzas required.
 *
 * @property partySize the number of people to be considered for pizza
 * @property hungerLevel the hunger level of the party attendees
 */
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    /**
     * Gets the total number of pizzas required based on party size and hunger level.
     */
    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}
