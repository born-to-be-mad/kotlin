package tasks.taxipark

import org.junit.Assert

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
class TaxiParkTaskTest {

    fun testFindFakeDrivers() {}

    fun testFindFaithfulPassengers() {}

    fun testFindFrequentPassengers() {}

    fun testFindSmartPassengers() {}

    fun testFindTheMostFrequentTripDurationPeriod() {}

    fun testCheckParetoPrinciple() {}

    private fun testFakeDrivers(fakeDriverIndexes: Set<Int>, tp: TaxiPark) {
        val message = "Wrong result for 'findFakeDrivers()'." + tp.display()
        val expected = fakeDriverIndexes.map { driver(it) }.toSet()
        Assert.assertEquals(message, expected, tp.findFakeDrivers())
    }

    private fun testFaithfulPassengers(minTrips: Int, passengerIndexes: Set<Int>, tp: TaxiPark) {
        val message = "Wrong result for 'findFaithfulPassengers()'. MinTrips: $minTrips." + tp.display()
        val expected = passengerIndexes.map { passenger(it) }.toSet()
        Assert.assertEquals(message, expected, tp.findFaithfulPassengers(minTrips))
    }

    private fun testFrequentPassengers(driverIndex: Int, passengerIndexes: Set<Int>, tp: TaxiPark) {
        val message = "Wrong result for 'findFrequentPassengers()'. Driver: ${driver(driverIndex).name}." + tp.display()
        val expected = passengerIndexes.map { passenger(it) }.toSet()
        Assert.assertEquals(message, expected, tp.findFrequentPassengers(driver(driverIndex)))
    }

    private fun testSmartPassengers(passengerIndexes: Set<Int>, tp: TaxiPark) {
        val message = "Wrong result for 'findSmartPassengers()'." + tp.display()
        val expected = passengerIndexes.map { passenger(it) }.toSet()
        Assert.assertEquals(message, expected, tp.findSmartPassengers())
    }

    private fun testDurationPeriod(expected: Set<IntRange?>, tp: TaxiPark) {
        val actual = tp.findTheMostFrequentTripDurationPeriod()
        val message = "Wrong result for 'findTheMostFrequentTripDurationPeriod()': $actual."
        if (expected.size <= 1) {
            Assert.assertEquals(
                message + tp.display(),
                expected.firstOrNull(), actual
            )
        } else {
            Assert.assertTrue(message +
                    tp.display() +
                    "\nPossible results: $expected" +
                    "\nActual: $actual\n",
                actual?.let { it in expected } ?: expected.isEmpty())
        }
    }

    private fun testPareto(expected: Boolean, tp: TaxiPark) {
        val message = "Wrong result for 'checkParetoPrinciple()'." + tp.display()
        Assert.assertEquals(message, expected, tp.checkParetoPrinciple())
    }
}