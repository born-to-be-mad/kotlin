package games.gameOfFifteen

import kotlin.random.Random

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialize the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        val rnd = Random(15)
        val listOfFifteen: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val shuffledList = listOfFifteen.shuffled(rnd).toMutableList()
        var currentIndex = 0;
        while (!isEven(shuffledList)) {
            val current = shuffledList[currentIndex]
            val next = shuffledList[currentIndex + 1]
            shuffledList[currentIndex] = next
            shuffledList[currentIndex + 1] = current
            if (currentIndex == listOfFifteen.size - 2) {
                currentIndex = 0
            } else {
                currentIndex++
            }
        }
        shuffledList.toList()
    }
}

