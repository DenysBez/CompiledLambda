package com.compiledlambda.matrix;

import com.compiledlambda.matrix.algo._


/**
 * @author Hp
 */
object ConsoleTest {
  def main(args: Array[String]) {
    val n = 2;
    val m = 4;

    val matrix = new Matrix(n, m)

    matrix.set(0, 0, 0.0)
    matrix.set(0, 1, 3.0)
    matrix.set(0, 2, 1.0)
    matrix.set(0, 3, 0.0)
    
    matrix.set(1, 0, 2.0)
    matrix.set(1, 1, 7.0)
    matrix.set(1, 2, 0.0)
    matrix.set(1, 3, 1.0)
    
    print(matrix)
    
    //matrix.exchangeRows(0, 1)

    GaussJordanElimination.apply(matrix)
    
    print(matrix)
  }
}