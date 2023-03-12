package com.example.pizzaparty

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test class that tests the behavior of the app on an Android device.
 * See [testing documentation](http://d.android.com/tools/testing) for more information.
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    /**
     * Test case that verifies that the app under test has the correct package name.
     * This test uses the [InstrumentationRegistry] to get a reference to the app context.
     */
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.pizzaparty", appContext.packageName)
    }
}
