package games.gameOfFifteen

import games.board.Direction
import games.board.GameBoard
import games.board.createGameBoard
import games.game.Game

/**
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
    GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {

    private val board: GameBoard<Int?> = createGameBoard(4)

    override fun initialize() {
        board.getAllCells()
            .zip(initializer.initialPermutation)
            .forEach { (cell, value) ->
                board[cell] = value
            }
    }

    override fun canMove(): Boolean {
        return true
    }

    override fun hasWon(): Boolean {
        var count = 1
        val boardWidth = board.width
        for (i in 1..boardWidth) {
            for (j in 1..boardWidth) {
                if (get(i, j) != count && count != boardWidth * boardWidth) {
                    return false
                }
                count++
            }
        }
        return true
    }

    override fun processMove(direction: Direction) {
        val emptyCell = board.getAllCells().first { board[it] == null }
        val neighbour = board.run { emptyCell.getNeighbour(direction.reversed()) }
        if (neighbour != null) {
            board[emptyCell] = board[neighbour]
            board[neighbour] = null
        }
    }

    override fun get(i: Int, j: Int): Int? {
        board.run {
            return get(getCell(i, j))
        }
    }

}
