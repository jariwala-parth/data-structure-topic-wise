package leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfTeams1395 {
    int ans = 0;
    Set<String> added = new HashSet<>();

    public int numTeams(int[] rating) {
        solve(rating, 0, 1);
        return ans;
    }

    public void solve(int[] rating, int start, int end) {
        if (start >= end || start == rating.length || end == rating.length) {
            return;
        }
        boolean low = rating[start] < rating[end];
        for (int middle = start + 1; middle < end; middle++) {
            String s = start + "~" + middle + "~" + end;
            boolean low2 = rating[start] < rating[middle];
            if (low != low2 || added.contains(s)) {
                continue;
            }
            if ((rating[middle] < rating[end]) == low) {
                ans++;
                added.add(s);
//                System.out.println(s);
            }
        }
        solve(rating, start + 1, end);
        solve(rating, start, end + 1);
    }

    public static void main(String[] args) {
        CountNumberOfTeams1395 countNumberOfTeams1395 = new CountNumberOfTeams1395();
        System.out.println(countNumberOfTeams1395.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(countNumberOfTeams1395.numTeams(new int[]{89, 61, 13, 36, 37, 39, 97, 76, 84, 18, 12, 24, 71, 33, 44, 85, 70, 82, 15, 74, 35, 66, 59, 8, 3, 96, 30, 16, 41, 7, 10, 68, 92, 83, 95, 77, 9, 14, 81, 88, 38}));
    }
}


