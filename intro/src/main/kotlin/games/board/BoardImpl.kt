package games.board

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)

fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

open class SquareBoardImpl(final override val width: Int) : SquareBoard {

    var cells: Array<Array<Cell>> = arrayOf()

    init {
        cells += createArray(width)
    }

    private fun createArray(width: Int): Array<Array<Cell>> {
        var cellsArray = arrayOf<Array<Cell>>()
        for (i in 1..width) {
            var array = arrayOf<Cell>()
            for (j in 1..width) {
                array += Cell(i, j)
            }
            cellsArray += array
        }

        return cellsArray
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        TODO("Not yet implemented")
    }

    override fun getCell(i: Int, j: Int): Cell {
        TODO("Not yet implemented")
    }

    override fun getAllCells(): Collection<Cell> {
        TODO("Not yet implemented")
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("Not yet implemented")
    }

}

class GameBoardImpl<T>(width: Int) : SquareBoardImpl(width), GameBoard<T> {

    private val boardCellsMap: MutableMap<Cell, T?> = mutableMapOf()

    override fun get(cell: Cell): T? {
        TODO("Not yet implemented")
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("Not yet implemented")
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        TODO("Not yet implemented")
    }

    override fun set(cell: Cell, value: T?) {
        TODO("Not yet implemented")
    }

}

