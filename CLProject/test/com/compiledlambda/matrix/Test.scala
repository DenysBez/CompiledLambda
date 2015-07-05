package com.compiledlambda.matrix;

/**
 * @author Hp
 */
object Test {
  def main(args: Array[String]) {
    val n = 2;
    val m = 2;

    val matrix = new Matrix(n, m)

    for (row <- 0 until n; column <- 0 until m) {
      matrix.set(row, column, row + 1 + column);
    }
    
    print(matrix)
    
    matrix.exchangeRows(0, 1)
    
    print(matrix)
  }
}