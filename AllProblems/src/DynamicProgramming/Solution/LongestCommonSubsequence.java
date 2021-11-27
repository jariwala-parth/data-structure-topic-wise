package DynamicProgramming.Solution;

public class LongestCommonSubsequence {
    int[][] dp;

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        System.out.println(lcs.solve("abbcdgf", "bbadcgf"));
        System.out.println(lcs.solve("abbcgf", "ababab"));
    }

    public int solve(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        dp = new int[a.length + 1][b.length + 1];
        lcm(a, b, a.length, b.length);
        return dp[a.length][b.length];
    }

    public void lcm(char[] a, char[] b, int m, int n) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
