package tasks.taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    allDrivers
        .filter { driver -> trips.none { trip -> trip.driver == driver } }
        .toSet()

fun TaxiPark.findFakeDrivers2(): Set<Driver> =
    //allDrivers.minus(trips.map { it.driver }.toSet())
    allDrivers - trips.map { it.driver }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    allPassengers
        .filter { passenger ->
            trips.count { trip -> passenger in trip.passengers } >= minTrips
        }
        .toSet()

fun TaxiPark.findFaithfulPassengers2(minTrips: Int): Set<Passenger> =
    trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= minTrips }
        .keys

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

fun TaxiPark.findFrequentPassengers1(driver: Driver): Set<Passenger> =
    allPassengers
        .filter { passenger ->
            trips.count { trip -> trip.driver == driver && passenger in trip.passengers } > 1
        }
        .toSet()

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

fun TaxiPark.findSmartPassengers1(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) = trips.partition { it.discount != null }
    return allPassengers
        .filter { passenger ->
            tripsWithDiscount.count { passenger in it.passengers } >
                    tripsWithoutDiscount.count { passenger in it.passengers }
        }
        .toSet()
}

fun TaxiPark.findSmartPassengers2(): Set<Passenger> =
    allPassengers
        .associate { passenger ->
            passenger to trips.filter { passenger in it.passengers }
        }
        .filterValues { trips ->
            trips.partition { it.discount != null }
                .let { (withDiscount, withoutDiscount) ->
                    withDiscount.size > withoutDiscount.size
                }
        }
        .keys

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there are no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return trips
        .groupBy {
            val start = it.duration / 10 * 10
            val end = start + 9
            start..end
        }
        .maxBy { (_, group) -> group.size }
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
    if (trips.isEmpty()) return false

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

fun TaxiPark.checkParetoPrinciple2(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumByDouble(Trip::cost)

    val sortedDriversIncome: List<Double> = trips
        .groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumOf(Trip::cost) }
        .sortedDescending()

    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedDriversIncome
        .take(numberOfTopDrivers)
        .sum()

    return incomeByTopDrivers >= 0.8 * totalIncome
}