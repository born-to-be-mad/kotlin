package tasks.board

import tasks.board.Direction.*

/**
 * SquareBoard.
 * SquareBoard stores the information about the square board and all the cells on it.
 * It allows the retrieval of a cell by its indexes, parts of columns and rows on a board, or a specified neighbor of a cell.
 * @impNote: Note that the numbering of cells starts with 1 (not 0).
 * A board of width two consists of the following cells:
 * (1, 1) (1, 2)
 * (2, 1) (2, 2)
 * For the following examples, we'll use this board of width 2:
 * val board = createSquareBoard(2)
 * If you call board.getCellOrNull(3, 3) for such a board, you'll get null as the result, because the board doesn't have a cell with such coordinates.
 * The function Board.getCell should throw IllegalArgumentException for incorrect values of i and j.
 * You can write board.getRow(1, 1..2) or board.getRow(1, 2 downTo 1), and you'll get the lists of cells [(1, 1), (1, 2)] and [(1, 2), (1, 1)] accordingly.
 * Note how using the range 2 downTo 1 returns a row in a reversed order. You can use any range to get a part of a column or a row.
 * Note that getRow and getColumn should return a list containing only the cells that belong to the board
 * if the range is larger than the board limits and ignore other indexes, thus, board.getRow(1, 1..10) should return [(1, 1), (1, 2)].
 * The neighbors of a cell (1, 1), depending on the direction should be:
 * Direction.UP - null
 * Direction.LEFT - null
 * Direction.DOWN - (2, 1)
 * Direction.RIGHT - (1, 2)
 * Create only width * width cells; all the functions working with cells should return existing cells instead of creating new ones.
 */
open class SquareBoardImpl(override val width: Int) : SquareBoard {

    var cells: Array<Array<Cell>> = arrayOf(arrayOf())

    override fun getCellOrNull(i: Int, j: Int): Cell? =
        when {
            i == 0 || j == 0 || i > width || j > width -> null
            else -> getCell(i, j)
        }

    override fun getCell(i: Int, j: Int): Cell = cells[i - 1][j - 1]

    override fun getAllCells(): Collection<Cell> =
        IntRange(1, width)
            .flatMap { i: Int ->
                IntRange(1, width).map { j: Int -> getCell(i, j) }
            }
            .toList()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> =
        when {
            jRange.last > width ->
                IntRange(jRange.first, width).map { j: Int -> getCell(i, j) }.toList()

            else ->
                jRange.map { j: Int -> getCell(i, j) }.toList()
        }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> =
        when {
            iRange.last > width ->
                IntRange(iRange.first, width).map { i: Int -> getCell(i, j) }.toList()

            else ->
                iRange.map { i: Int -> getCell(i, j) }.toList()
        }

    override fun Cell.getNeighbour(direction: Direction): Cell? =
        when (direction) {
            UP -> getCellOrNull(i - 1, j)
            LEFT -> getCellOrNull(i, j - 1)
            DOWN -> getCellOrNull(i + 1, j)
            RIGHT -> getCellOrNull(i, j + 1)
        }
}

fun createSquareBoard(width: Int): SquareBoard {
    val sq = SquareBoardImpl(width)
    sq.cells = createEmptyBoard(width)
    return sq
}

fun <T> createGameBoard(width: Int): GameBoard<T> {
    val gb = GameBoardImpl<T>(width)
    gb.cells = createEmptyBoard(width)
    gb.cells.forEach { it.forEach { cell: Cell -> gb.cellValues += cell to null } }
    return gb
}

/**
 * GameBoard.
 * GameBoard allows you to store values in board cells, update them, and enquire about stored values
 * (like any, all etc.) Note that GameBoard extends SquareBoard.
 * Don't store a value in a Cell: data class Cell is intended to be immutable and only store the coordinates.
 * You can store values separately, for instance, in a map from Cell to stored values type.
 * See TestSquareBoard and TestGameBoard for examples.
 */
class GameBoardImpl<T>(override val width: Int) : SquareBoardImpl(width), GameBoard<T> {

    val cellValues = mutableMapOf<Cell, T?>()

    override fun get(cell: Cell): T? = cellValues[cell]

    override fun set(cell: Cell, value: T?) {
        cellValues += cell to value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> =
        cellValues.filterValues { predicate.invoke(it) }.keys

    override fun find(predicate: (T?) -> Boolean): Cell =
        cellValues.filter { predicate.invoke(it.value) }.keys.first()

    override fun any(predicate: (T?) -> Boolean): Boolean =
        cellValues.values.any(predicate)

    override fun all(predicate: (T?) -> Boolean): Boolean =
        cellValues.values.all(predicate)
}

private fun createEmptyBoard(width: Int): Array<Array<Cell>> {
    var board = arrayOf<Array<Cell>>()

    for (i in 1..width) {
        var array = arrayOf<Cell>()
        for (j in 1..width) {
            array += Cell(i, j)
        }
        board += array
    }
    return board
}
