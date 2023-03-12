package com.example.pizzaparty

import PizzaCalculator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

// Constant used for logging
const val TAG = "MainActivity"

// Key used to save and restore the state of total pizzas
private const val KEY_TOTAL_PIZZAS = "totalPizzas"

/**
 * MainActivity responsible for handling user input and displaying output on the home screen.
 */
class MainActivity : AppCompatActivity() {

    // Views used in the layout
    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    // Variable used to store the total number of pizzas needed
    private var totalPizzas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate was called")

        // Find the views in the layout and assign them to the corresponding variables
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)

        // Restore state if available
        if (savedInstanceState != null) {
            totalPizzas = savedInstanceState.getInt(KEY_TOTAL_PIZZAS)
            displayTotal()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current state of total pizzas
        outState.putInt(KEY_TOTAL_PIZZAS, totalPizzas)
    }

    /**
     * Called when the user clicks the "Calculate" button to calculate the total number
     * of pizzas needed.
     */
    fun calculateClick(view: View) {
        // Get the number of attendees entered by the user
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toIntOrNull() ?: 0

        // Get the hunger level selected by the user
        val hungerLevel = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }

        // Calculate the total number of pizzas needed using the PizzaCalculator class
        val calc = PizzaCalculator(numAttend, hungerLevel)
        totalPizzas = calc.totalPizzas

        // Display the total number of pizzas needed on the screen
        displayTotal()
    }

    /**
     * Updates the text in the "Total Pizzas" TextView to display the total number
     * of pizzas needed.
     */
    private fun displayTotal() {
        val totalText = getString(R.string.total_pizzas, totalPizzas)
        numPizzasTextView.text = totalText
    }
}
