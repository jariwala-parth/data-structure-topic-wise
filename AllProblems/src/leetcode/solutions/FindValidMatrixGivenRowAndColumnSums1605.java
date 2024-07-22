package leetcode.solutions;

import java.util.Arrays;

public class FindValidMatrixGivenRowAndColumnSums1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        int m = rowSum.length, n = colSum.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }

    public int[][] restoreTry(int[][] matrix, int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }
    boolean checkRowSum(int[][] matrix, int sum, int rowNumber) {
        int rowSum = 0;
        for (int i = 0; i < matrix[rowNumber].length; i++) {
            rowSum += matrix[rowNumber][i];
        }
        return rowSum == sum;
    }
    boolean checkColSum(int[][] matrix, int sum, int colNumber) {
        int colSum = 0;
        for (int[] ints : matrix) {
            colSum += ints[colNumber];
        }
        return colSum == sum;
    }
    public static void main(String[] args) {
        FindValidMatrixGivenRowAndColumnSums1605 obj = new FindValidMatrixGivenRowAndColumnSums1605();

        System.out.println(Arrays.deepToString(obj.restoreMatrix(new int[]{3, 8}, new int[]{4, 7})));
        System.out.println(Arrays.deepToString(obj.restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
    }
}
