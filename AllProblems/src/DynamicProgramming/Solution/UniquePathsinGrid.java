package DynamicProgramming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePathsinGrid {
    public static void main(String[] args) {
        UniquePathsinGrid uniquePathsinGrid = new UniquePathsinGrid();
        System.out.println(
                uniquePathsinGrid.uniquePathsWithObstacles(
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(List.of(0, 0, 0)),
                                new ArrayList<>(List.of(0, 1, 0)),
                                new ArrayList<>(List.of(0, 0, 0))
                        ))
                )
        );
        System.out.println(
                uniquePathsinGrid.uniquePathsWithObstacles(
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(List.of(0, 0, 0)),
                                new ArrayList<>(List.of(1, 1, 1)),
                                new ArrayList<>(List.of(0, 0, 0))
                        ))
                )
        );
    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m][n];
        if (A.get(0).get(0) == 1) {
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (A.get(i).get(0) == 1) {
                flag = true;
            }
            if (!flag) {
                dp[i][0] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            if (A.get(0).get(i) == 1) {
                flag = true;
            }
            if (!flag) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.get(i).get(j) == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
