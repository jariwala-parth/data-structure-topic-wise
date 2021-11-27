package DynamicProgramming.Solution;

import java.util.List;

public class MaxProductSubarray {
    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        System.out.println(maxProductSubarray.maxProduct(List.of(4, 2, -5, 1))); // 8
        System.out.println(maxProductSubarray.maxProduct(List.of(10, 23, -20, 44, 3, -4))); // product of all elements = 2428800
    }

    public int maxProduct(final List<Integer> A) {
        int max = A.get(0), min = A.get(0), ans = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int a = A.get(i);
            if (a < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * a, a);
            min = Math.min(min * a, a);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
