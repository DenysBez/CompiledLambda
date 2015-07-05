package com.compiledlambda.matrix

import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.hamcrest.core.Is._
import org.hamcrest.core.IsEqual.equalTo


class MatrixTest {

  @Test def isSquareMatrix() {
    val matrix = initMatrix()

    assertTrue(matrix.isSquare())
  }

  @Test def calculateDet() {
    val matrix = initMatrix()
    
    assertThat(matrix.det(), is[Double](equalTo(-1.0)))    
  }
  
  @Test def scalarMultiply() {
    val matrix = initMatrix()
    
    matrix.scalarMultiply(2);
    
    assertThat(matrix.det(), is[Double](equalTo(-4.0)))
  }
  
  
  @Test def inverse() {
    val matrix = initMatrix()
    
    val inverse = matrix.inverse()
    
    assertThat(inverse.ent(0, 0), is[Double](equalTo(-3.0)))
    assertThat(inverse.ent(0, 1), is[Double](equalTo(2.0)))
    assertThat(inverse.ent(1, 0), is[Double](equalTo(2.0)))
    assertThat(inverse.ent(1, 1), is[Double](equalTo(-1.0)))    
  }
  
  @Test def exchangeRows() {
    val matrix = initMatrix()
    matrix.exchangeRows(0, 1);
    
    assertThat(matrix.ent(0, 0), is[Double](equalTo(2.0)))
    assertThat(matrix.ent(0, 1), is[Double](equalTo(3.0)))
    assertThat(matrix.ent(1, 0), is[Double](equalTo(1.0)))
    assertThat(matrix.ent(1, 1), is[Double](equalTo(2.0)))
  }
  
  def initMatrix() : Matrix = {
    val n = 2;
    val m = 2;

    val matrix = new Matrix(n, m)

    for (row <- 0 until n; column <- 0 until m) {      
        matrix.set(row, column, row + 1 + column)      
    }    
    
    return matrix
  }
}