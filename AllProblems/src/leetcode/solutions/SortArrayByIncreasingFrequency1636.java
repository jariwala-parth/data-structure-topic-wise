package leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArrayByIncreasingFrequency1636 {

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency1636 obj = new SortArrayByIncreasingFrequency1636();
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }
    class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

    }
    public int[] frequencySort(int[] nums) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count == 0 ? o2.num - o1.num : o1.count - o2.count);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        freq.forEach(
                (num,count) -> queue.offer(new Pair(num, count))
        );
        int[] ans = new int[nums.length];
        int i = 0;
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            for(int j = 0; j < p.count; j++) {
                ans[i++] = p.num;
            }
        }
        return ans;
    }
}
