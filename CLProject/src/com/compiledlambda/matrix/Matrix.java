package com.compiledlambda.matrix;

public class Matrix {

	private final double[][] matrix;
	
	public Matrix(int rows, int columns) {
		if(rows <= 0 || columns <= 0) {
			throw new IllegalArgumentException("Cannot create matrix with zero rows or columns");
		}			
			 
		double[][] storage = new double[rows][];
		for(int i = 0; i < storage.length; ++i) {
			storage[i] = new double[columns];
		}
		this.matrix = storage;
	}
	
	
	public boolean isSquare() {
		return matrix.length == matrix[0].length;
	}
	
	public static void main(String[] args) {

		Matrix matrix = new Matrix(4, 3);
		System.out.println(matrix.isSquare());
	}

}
