package leetcode.solutions;

public class MinimumSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {

        // NO NEGATIVE NUMBERS...
        int start = 0, end = 0, ans = Integer.MAX_VALUE, currSum = nums[start];
        while (start <= end && end < nums.length) {
            //  System.out.println("start = " + start + " end = " + end + " currSum = " + currSum);
            if (nums[start] == target || nums[end] == target) {
                return 1;
            }
            if (currSum >= target) {
                ans = Math.min(ans, end - start + 1);
                currSum -= nums[start];
                start++;
            } else {
                end++;
                if (end < nums.length) {
                    currSum += nums[end];
                }
            }
            if (start > end) {
                end = start;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum209 minimumSizeSubarraySum209 = new MinimumSizeSubarraySum209();
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(4, new int[]{1, 5, 4}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(7, new int[]{1, 5, 2}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(7, new int[]{1, 5, 2, 3}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(7, new int[]{1, 5, 1, 3}));
        System.out.println(minimumSizeSubarraySum209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
