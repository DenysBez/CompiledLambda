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
	
	public void set(int row, int column, double value) {
		this.matrix[row][column] = value;
	}
	
	/**
	 * Element in the row, column position of Matrix
	 */
	public double ent(int row, int column) {
		return this.matrix[row][column];
	}
	
	/**
	 * Computes determinant
	 */
	public double det() {
		if(!isSquare()) {
			throw new IllegalArgumentException("determinant can be computed only for a square matrix");
		}
		
		return (ent(0, 0) * ent(1, 1)) - (ent(0, 1) * ent(1, 0));
	}
	
	public boolean isSquare() {
		return getRowsLength() == getColumntLength();
	}
	
	/**
	 * Tests if square matrix is not invertible, i.e. singular or degenerate
	 * 
	 * TODO: A square matrix is singular if and only if its determinant is 0
	 */
	public boolean isSingular() {
		if(!isSquare()) {
			return false;
		}
		//TODO:
		return false;
	}

	public int getColumntLength() {
		return this.matrix.length;
	}
	
	public int getRowsLength() {
		return this.matrix[0].length;
	}
	
	
	public Matrix exchangeRows(int firstRowIdx, int secondRowIdx) {
		double[] firstRow = this.matrix[firstRowIdx];
		double[] secondRow = this.matrix[secondRowIdx];
		
		this.matrix[firstRowIdx] = secondRow;
		this.matrix[secondRowIdx] = firstRow;
		
		return this;
	}

	/**
	 * Scalar multiplication, changes state of current matrix
	 */
	public Matrix scalarMultiply(double scalar) {
		for(int row = 0; row < getRowsLength(); ++row) {
			for(int column = 0; column < getColumntLength(); ++column) {
				set(row, column, scalar * ent(row, column));
			}
		}
		
		return this;
	}
	
	public Matrix inverse() {			
		double det = det();
		if(det != 0) {
			if(getRowsLength() == 2 && getColumntLength() == 2) {
				final Matrix inverted = new Matrix(getRowsLength(), getColumntLength());
				inverted.set(0, 0, this.ent(1, 1));
				inverted.set(0, 1, (-1) * this.ent(0, 1));
				inverted.set(1, 0, (-1) * this.ent(1, 0));
				inverted.set(1, 1, this.ent(0, 0));
				inverted.scalarMultiply(1 / det);
				return inverted;
			}			
		}
		throw new UnsupportedOperationException("inverse calculation not supported for non-2x2 matrices");

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
