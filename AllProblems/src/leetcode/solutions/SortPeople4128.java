package leetcode.solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortPeople4128 {
    class Pair {
        int h;
        int i;
        Pair(int h, int i) {
            this.h = h;
            this.i = i;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.h - o1.h);
        for(int i = 0; i < names.length; i++) {
            queue.add(new Pair(heights[i], i));
        }
        String[] s = new String[names.length];
        int i = 0;
        while(!queue.isEmpty()) {
            s[i++] = names[queue.poll().i];
        }
        return s;
    }

    public static void main(String[] args) {
        SortPeople4128 sortPeople = new SortPeople4128();
        System.out.println(Arrays.toString(sortPeople.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
}
