package leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals56 {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int[][] ans = new int[intervals.length][2];
    int index = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (i == intervals.length - 1 || intervals[i + 1][0] > intervals[i][1]) {
        ans[index++] = intervals[i];
      } else {
        ans[index++] = new int[]{intervals[i][0], intervals[i + 1][1]};
        i++;
      }
    }
    return Arrays.copyOfRange(ans, 0, index);
  }

  public static void main(String[] args) {

    MergeIntervals56 obj = new MergeIntervals56();
    System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 3}, {15, 18}, {2, 6}, {8, 10}, {20, 21}})));
    System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 4}, {4, 5}})));
    System.out.println(Arrays.deepToString(obj.merge(new int[][]{{1, 4}, {2, 3}})));
  }
}
