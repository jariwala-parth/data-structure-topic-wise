package leetcode.solutions;

import java.util.Arrays;

public class MinimumDeletionsToMakeStringBalanced1653 {
    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();
        int a = 0, b = 0, ans = arr.length;
        for (char c : arr) {
            if (c == 'a') {
                a++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                a--;
            }
            ans = Math.min(ans, a + b);
            if (arr[i] == 'b') {
                b++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced1653 m = new MinimumDeletionsToMakeStringBalanced1653();
        System.out.println(m.minimumDeletions("abbbababbbb"));
        System.out.println(m.minimumDeletions("aababbab"));
        System.out.println(m.minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
    }
}
