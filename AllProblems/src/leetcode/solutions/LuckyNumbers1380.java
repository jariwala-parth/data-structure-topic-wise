package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int[] maxRow = new int[m];
        int[] maxCol = new int[n];

        // 3  7  8
        // 9  11 13
        // 15 16 17
        // {1, 10,4, 2}
        // {9, 3 ,8, 7}
        // {15,16,17,12}
        System.out.println("m: " + m + " n: " + n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxInRow = findMinInRow(matrix, j);
                int maxInCol = findMaxInCol(matrix, i);
                if (maxInRow == maxInCol) {
                    ans.add(maxInRow);
                }
            }
            System.out.println("maxRow: " + Arrays.toString(maxRow) + " maxCol: " + Arrays.toString(maxCol));
        }

        return ans;
    }

    public int findMinInRow(int[][] matrix, int rowNumber) {
        int max = Integer.MAX_VALUE;
        int col = matrix[rowNumber].length;
        for (int i = 0; i < col; i++) {
            if (matrix[rowNumber][i] < max) {
                max = matrix[rowNumber][i];
            }
        }
        return max;
    }

    public int findMaxInCol(int[][] matrix, int colNumber) {
        int max = Integer.MIN_VALUE;
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][colNumber] > max) {
                max = matrix[i][colNumber];
            }
        }
        return max;
    }
}
