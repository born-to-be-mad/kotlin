package tasks.taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers
        .filter { driver -> trips.none { trip -> trip.driver == driver } }
        .toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers
        .filter { passenger ->
            trips.count { trip -> passenger in trip.passengers } >= minTrips
        }
        .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    trips
        .filter { trip -> trip.driver == driver }
        .flatMap { trip -> trip.passengers }
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .keys

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    allPassengers
        .filter { passenger ->
            val withDiscount = trips.count { trip -> passenger in trip.passengers && trip.discount != null }
            val withoutDiscount = trips.count { trip -> passenger in trip.passengers && trip.discount == null }
            withDiscount > withoutDiscount
        }
        .toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there are no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val durations = trips.map { it.duration }
    return durations
        .groupingBy { it / 10 * 10..it / 10 * 10 + 9 }
        .eachCount()
        .maxBy { it.value }
        ?.key
}

/*
 * Task #6. Check whether no more than 20% of the drivers contribute 80% of the income.
 * The function should return true if the top 20% drivers (meaning the top 20% best performers) represent 80%
 * or more of all trips total income, or false if not.
 * The drivers that have no trips should be considered as contributing zero income.
 * If the taxi park contains no trips, the result should be false.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    // If the taxi park contains no trips, the result should be false.
    if(trips.isEmpty()) return false

    val driversIncome: Map<Driver, Double> = trips.groupingBy { it.driver }
        .fold(0.0) { sum, trip -> sum + trip.cost }
    val totalIncome = driversIncome.values.sum()
    val amountOfTopContributors = Integer.max(allDrivers.size / 5, 1)

    val top20Income = driversIncome.values
        .sortedDescending()
        .take(amountOfTopContributors)
        .sum()
    return top20Income >= totalIncome * 0.8
}