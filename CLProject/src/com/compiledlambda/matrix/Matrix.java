package com.compiledlambda.matrix;

/**
 * Basic Matrix implementation
 */
public class Matrix {

	private final double[][] matrix;
	
	public Matrix(int rows, int columns) {
		if(rows <= 0 || columns <= 0) {
			throw new IllegalArgumentException("Cannot create a matrix with zero rows or columns");
		}			
			 
		double[][] storage = new double[rows][];
		for(int i = 0; i < storage.length; ++i) {
			storage[i] = new double[columns];
		}
		this.matrix = storage;
	}
	
	public void set(int i, int j, double value) {
		matrix[j][i] = value;
	}
	
	public double ent(int i, int j) {
		return matrix[j][i];
	}
	
	public boolean isSquare() {
		return matrix.length == matrix[0].length;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Matrix [");
		builder.append("\n");
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j =0; j < matrix[i].length; ++j) {
				builder.append(ent(i, j));
				builder.append(" ");
			}
			builder.append("\n");
		}
		
		builder.append("]");
		
		return builder.toString();
	}	

}
