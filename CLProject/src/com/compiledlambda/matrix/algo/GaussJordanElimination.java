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
		stepOne(matrix);
	}


	private static void stepOne(Matrix matrix) {
		int column = 0;
		for(int rowCurrent = 0; rowCurrent < matrix.getRowsLength() - 1; ++rowCurrent) {
			if(matrix.ent(rowCurrent, column) == 0) {
				for(int rowBelow = rowCurrent + 1; rowBelow < matrix.getRowsLength(); ++rowBelow) {
					if(matrix.ent(rowBelow, column) != 0) {
						matrix.exchangeRows(rowCurrent, rowBelow);
					}
				}
				if(matrix.ent(rowCurrent, column) == 0) {
					++column;
				}
			}
		}
	}
}
