package leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MinimumNumbersToPushToTypeWordII3016 {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] w = word.toCharArray();
        for(char c: w) {
            map.merge(c, 1, Integer::sum);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparingInt(map::get).reversed());
        pq.addAll(map.keySet());

        int count = 0, ans = 0;
        while (!pq.isEmpty()) {
            ans += map.get(pq.poll()) * (1 + (count / 8));
            count++;
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumNumbersToPushToTypeWordII3016 numbers = new MinimumNumbersToPushToTypeWordII3016();
        System.out.println(numbers.minimumPushes("abcde"));
        System.out.println(numbers.minimumPushes("xyzxyzxyzxyz"));
        System.out.println(numbers.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
