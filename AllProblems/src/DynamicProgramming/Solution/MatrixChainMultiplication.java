package DynamicProgramming.Solution;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        MatrixChainMultiplication m = new MatrixChainMultiplication();

        System.out.println(m.minimumCostOfMultiplication(new int[]{40, 20, 30, 10, 30}));
        System.out.println(m.minimumCostOfMultiplication(new int[]{10, 20, 30}));
    }

    public int minimumCostOfMultiplication(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];
        int j;
        for (int C = 2; C < n; C++) {
            for (int i = 1; i < n - C + 1; i++) {
                j = i + C - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }
}
