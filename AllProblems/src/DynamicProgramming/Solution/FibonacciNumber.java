package DynamicProgramming.Solution;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] dp = new int[number + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[number]);
    }
}
