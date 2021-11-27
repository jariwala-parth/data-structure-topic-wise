package DynamicProgramming.Solution;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("abad", "abac"));
        System.out.println(editDistance.minDistance("Parth", "Jariwala")); // P -> J = 1, iwala = 5 , total = 6
    }

    public int minDistance(String From, String To) {
        char[] a = From.toCharArray();
        char[] b = To.toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[a.length][b.length];
    }
}
