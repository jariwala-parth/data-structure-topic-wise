package DynamicProgramming.Solution;

import java.util.Arrays;

public class Stairs {
    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        System.out.println(stairs.climbStairs(3));
        System.out.println(stairs.climbStairs(5));
        System.out.println(stairs.climbStairs(35));
    }

    public int climbStairs(int A) {
        int[] dp = new int[Math.max(3, A + 1)];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return helper(dp, A);
    }

    public int helper(int[] dp, int A) {
        if (A < 0) {
            return 0;
        }
        if (A <= 2) {
            return dp[A];
        }
        if (dp[A] == -1) {
            dp[A] = helper(dp, A - 1) + helper(dp, A - 2);
        }
        return dp[A];
    }
}
