package DynamicProgramming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements m = new MaxSumWithoutAdjacentElements();
        System.out.println(m.adjacentSum(new ArrayList<>(Arrays.asList(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(2))))));
        System.out.println(m.adjacentSum(new ArrayList<>(Arrays.asList(new ArrayList<>(List.of(1, 2, 3, 4)), new ArrayList<>(List.of(2, 3, 4, 5))))));
    }

    public int adjacentSum(ArrayList<ArrayList<Integer>> A) {
        int c = A.get(0).size();
        if (c == 0) {
            return 0;
        }
        int[] dp = new int[c];
        dp[0] = Math.max(A.get(0).get(0), A.get(1).get(0));
        if (c == 1) {
            return dp[0];
        }
        dp[1] = Math.max(A.get(0).get(1), A.get(1).get(1));
        dp[1] = Math.max(dp[0], dp[1]);
        if (c == 2) {
            return dp[1];
        }
        for (int j = 2; j < c; j++) {
            dp[j] = Math.max(A.get(0).get(j), A.get(1).get(j));
            dp[j] = Math.max(dp[j - 1], dp[j] + dp[j - 2]);
        }
        return dp[c - 1];
    }
}
