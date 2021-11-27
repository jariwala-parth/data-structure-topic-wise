package DynamicProgramming.Solution;

public class LetsParty {
    public static void main(String[] args) {
        LetsParty letsParty = new LetsParty();
        System.out.println(letsParty.solve(10));
        System.out.println(letsParty.solve(25));
        System.out.println(letsParty.solve(1023));
    }

    public int solve(int A) {
        if (A <= 2) {
            return A;
        }
        long MOD = 10003;
        long[] dp = new long[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= A; i++) {
            dp[i] = (dp[i - 1] + (((i - 1) * dp[i - 2])) % MOD) % MOD;
        }
        return (int) (dp[A] % MOD);
    }
}
