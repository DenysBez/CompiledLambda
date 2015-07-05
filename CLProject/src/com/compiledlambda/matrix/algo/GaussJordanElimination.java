/**
 * 
 */
package com.compiledlambda.matrix.algo;

import com.compiledlambda.matrix.Matrix;

/**
 * 
 *
 */
public class GaussJordanElimination {

	public static void apply(Matrix matrix) {			
		int rows = matrix.getRowsLength();
		int columns = matrix.getColumntLength();
		
		int maxIter = Math.min(rows, columns);
		
		for(int i = 0; i < maxIter; ++i) {
			int rowWithMax = argMaxForAbsValue(i, matrix);
			
			if(i != rowWithMax) {
				matrix.exchangeRows(i, rowWithMax);
			}
			
			for(int row = i + 1; row < rows; ++row) {
				pivot(i, row, matrix);
			}
		}
	}
	
	private static void pivot(int i, int row, Matrix matrix) {
		for(int column= i + 1; column < matrix.getColumntLength(); ++column) {
			matrix.set(row, column, matrix.ent(row, column) - matrix.ent(i, column) * (matrix.ent(row, i) / matrix.ent(i, i)));
		}
		matrix.set(row, i, 0);
	}
	
	private static int argMaxForAbsValue(int column, Matrix matrix) {
		double maxElementAbs = Math.abs(matrix.ent(0, column));
		int rowWithMax = 0;
		
		for(int row = 1; row < matrix.getRowsLength(); ++row) {
			if(maxElementAbs > Math.abs(matrix.ent(row, column))) {
				maxElementAbs = Math.abs(matrix.ent(row, column));
				rowWithMax = row;
			}
		}
		
		return rowWithMax;
	}

}
