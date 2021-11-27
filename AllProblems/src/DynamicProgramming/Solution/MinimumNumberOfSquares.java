package DynamicProgramming.Solution;

public class MinimumNumberOfSquares {
    public static void main(String[] args) {
        MinimumNumberOfSquares m = new MinimumNumberOfSquares();
        System.out.println(m.minimumSquares(5));
        System.out.println(m.minimumSquares(16));
        System.out.println(m.minimumSquares(207));
        System.out.println(m.minimumSquares(463));
    }

    public int minimumSquares(int A) {
        int[] dp = new int[A + 1];
        if (A <= 2) {
            return A;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= A; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int steps = 1 + dp[i - (j * j)];
                min = Math.min(min, steps);
            }
            dp[i] = min;
        }
        return dp[A];
    }
}
