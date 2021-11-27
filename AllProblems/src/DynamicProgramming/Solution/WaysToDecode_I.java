package DynamicProgramming.Solution;

public class WaysToDecode_I {
    public static void main(String[] args) {
        WaysToDecode_I waysToDecode = new WaysToDecode_I();
        System.out.println(waysToDecode.numberOfDecoding("12")); // 2
        System.out.println(waysToDecode.numberOfDecoding("8")); // 1
        System.out.println(waysToDecode.numberOfDecoding("203211221232212")); // 170
    }

    public int numberOfDecoding(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        long[] dp = new long[A.length() + 1];
        long MOD = 1000000007;
        char[] arr = A.toCharArray();
        dp[arr.length] = 1;
        dp[arr.length - 1] = arr[arr.length - 1] != '0' ? 1 : 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int first = arr[i] - '0';
            int second = (arr[i] - '0') * 10 + (arr[i + 1] - '0');

            if (first == 0) {
                continue;
            }
            if (first == 1 || (second >= 10 && second <= 26)) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
            dp[i] %= MOD;
        }
        return (int) (dp[0] % MOD);
    }
}
