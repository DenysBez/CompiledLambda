package com.compiledlambda.matrix;

public class MainTest {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(10, 10);
		System.out.println(matrix.isSquare());
		for(int row = 0; row < 10; ++row) {
			for(int column = 0; column < 10; column++) {
				matrix.set(row, column, row);
			}
		}
		
		System.out.println("is square: " + matrix);
	}

}
