package com.compiledlambda.matrix;

public class MainTest {

	public static void main(String[] args) {
		int n = 2;
		int m = 2;
		Matrix matrix = new Matrix(n, m);
		System.out.println("is square: " + matrix.isSquare());
		
		for(int row = 0; row < n; ++row) {
			for(int column = 0; column < m; column++) {
				matrix.set(row, column, row + 1 + column);
			}
		}
				
		System.out.println(matrix);
	}

}
