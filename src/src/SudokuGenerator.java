package src;

import java.util.Random;

/**
 * 
 * @author Aditya Gudipudi
 * 
 */

public class SudokuGenerator {

	/**
	 * initializes variables
	 * 
	 */
	static final int rangeMax = 3, rangeMin = 0, maxDigitValue = 4, minDigitValue = 1, minNumbersToGenerate = 4, maxNumbersToGenerate = 6;
	static int[][] grid = new int[4][4];
	static int row = 0;
	static int col = 0;
	static int randomNumber = 0;
	static int noOfCellsToBeGenerated = 0;
	static Random random = new Random();
	
	/**
	 * Returns a boolean indicating if the generated Sudoku puzzle is valid 
	 * 
	 * @param sudokuMatrix 4*4 array to generate Sudoku puzzle
	 * @param rowNumber row number being traversed
	 * @param columnNumber column number being traversed
	 * @param insertNumber random number to be inserted
	 * @return boolean returns a boolean if all the numbers inserted are valid
	 */
	
	public static boolean checkInsertedNumbers(int[][] sudokuMatrix, int rowNumber, int columnNumber, int insertNumber) {
		for (int i = 0; i < 4; i++) {
			if (sudokuMatrix[rowNumber][i] == insertNumber) {
				return false;
			}
			if (sudokuMatrix[i][columnNumber] == insertNumber) {
				return false;
			}
		}
		int gridRow = rowNumber - (rowNumber % 2);
		int gridColumn = columnNumber - (columnNumber % 2);
		for (int p = gridRow; p < gridRow + 2; p++) {
			for (int q = gridColumn; q < gridColumn + 2; q++) {
				if (sudokuMatrix[p][q] == insertNumber) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Prints the generated puzzle
	 * 
	 */
	public static void printPuzzle() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Generates sudoku puzzle by inserting random values at random positions in the array matrix
	 */

	public static void generatePuzzle() {
		for (int i = 1; i <= noOfCellsToBeGenerated; i++) {
			row = random.nextInt(( rangeMax - rangeMin) + 1) + rangeMin;
			col = random.nextInt(( rangeMax - rangeMin) + 1) + rangeMin;
			randomNumber = random.nextInt((maxDigitValue - minDigitValue) + 1) + minDigitValue;

			if (grid[row][col] == 0 && checkInsertedNumbers(grid, row, col, randomNumber)) {
				grid[row][col] = randomNumber;
			} else {
				i--;
			}
		}
	}
	
	/**
	 * 
	 * Main method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		noOfCellsToBeGenerated = random.nextInt((maxNumbersToGenerate - minNumbersToGenerate) + 1) + minNumbersToGenerate;
		generatePuzzle();
		printPuzzle();
	}
}