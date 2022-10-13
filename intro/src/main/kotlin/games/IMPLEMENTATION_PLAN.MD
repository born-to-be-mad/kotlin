# Game 2048

- [x] Implement the functionality that moves the content in one row or column: removes empty cells and merges identical
  elements.   
  To get you familiar with lambdas and generics, this functionality is declared as a generic function that accepts as
  argument, a method to merge two equal elements.  
  Source: `Game2048Helper.kt`; tests: `TestGame2048Helper.kt`.

- [ ] Specify how the new element should be added(function `nextValue`). By the rules of the game 2048, the new cell with the value 2 or 4 (
  the latter in 10% of the cases) is added to a random empty cell.  
  Source: `Game2048Initializer.kt`; tests: `TestGame2048Initializer.kt`.

- [ ] You can find the main game process in the Game2048 class. Implement the utility function `addNewValue` that adds a
  new value to a random free cell.   
  The initializer parameter returns both a value and a cell that the new value should be added to.  
  Source: `Game2048.kt`; tests: `TestAddingValue.kt`.

- [ ] Implement the utility function `moveValuesInRowOrColumn`, which updates the map contents by moving the elements only
  in one row or column.  
  Source: `Game2048.kt`; tests: `TestMoveValuesInRowOrColumn.kt`.

- [ ] Implement the remaining function `moveValues`, which moves all the elements in a board to a given direction
  following the rule games.  
  Source: `Game2048.kt`; tests: `TestMoveValues.kt`.

# Game 15

- [x] Game of Fifteen is solvable only if the initial permutation of numbers is even.  
  First, implement the function `isEven` declared in `GameOfFifteenHelper.kt` checking whether a permutation is even or
  odd.   
  Source: `GameOfFifteenHelper.kt`; tests: `TestGameOfFifteenHelper.kt`.
- [ ] Use the isEven function to produce only solvable permutations as initial permutations.   
  Source: `GameOfFifteenInitializer.kt`; tests: `TestGameOfFifteenInitializer.kt`.
- [ ] Implement the `GameOfFifteen` class from scratch describing the game process.   
  It should implement the `Game` interface and make use of initializer argument.   
  Note that this argument is used in tests to provide a different initial permutation.   
  Source: `GameOfFifteen.kt`; tests: `TestGameOfFifteen.kt`. 