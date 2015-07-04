package com.compiledlambda.matrix

import org.junit.Assert._
import org.junit.Test
import org.junit.Before


class MatrixTest {
  
  @Test def isSquareMatrix() {
    val n = 2;
    val m = 2;
    
    val matrix = new Matrix(n, m)
    
    assertTrue(matrix.isSquare())
  }
  
}