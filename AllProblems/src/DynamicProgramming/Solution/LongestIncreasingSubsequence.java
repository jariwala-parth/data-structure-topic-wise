package DynamicProgramming.Solution;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lisNONoptimalSolution(new ArrayList<>(List.of(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))));
        System.out.println(lis.lisOptimalSolution(new ArrayList<>(List.of(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))));
    }

    public int lisNONoptimalSolution(final List<Integer> A) {

        int[] dp = new int[A.size()];

        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < A.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((A.get(i) > A.get(j)) && (dp[i] < (dp[j] + 1))) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lisOptimalSolution(final List<Integer> A) {

        int[] dp = new int[A.size()];

        dp[0] = A.get(0);
        int len = 1;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > dp[len - 1]) {
                dp[len++] = A.get(i);
            } else {
                int index = find(dp, 0, len - 1, A.get(i));
                dp[index] = A.get(i);
            }
        }
        return len;
    }

    public int find(int[] dp, int l, int r, int val) {
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (dp[mid] == val) {
                return mid;
            }
            if (dp[mid] > val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
