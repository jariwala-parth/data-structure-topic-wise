package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuildMatrixWithConditions2392 {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];

        List<Integer> rows = addNodesToGraph(rowConditions, k);
        List<Integer> cols = addNodesToGraph(colConditions, k);
        if (rows.size() < k || cols.size() < k) {
            return new int[][]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(cols.get(i), i);
        }

        for (int i = 0; i < k; i++) {
            int colPosition = map.get(rows.get(i));
            matrix[i][colPosition] = rows.get(i);
        }
        return matrix;
    }
    List<Integer> addNodesToGraph(int[][] conditions, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] deg = new int[k + 1];
        for(int[] condition : conditions){
            graph.get(condition[0]).add(condition[1]);
            deg[condition[1]]++;
        }
        Queue<Integer> q = new PriorityQueue<>();
        List<Integer> order = new ArrayList<>();
        for(int i = 1 ; i < deg.length; i++){
            if(deg[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.remove();
            order.add(u);
            for (int v : graph.get(u)) {
                deg[v]--;
                if (deg[v] == 0) {
                    q.add(v);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        BuildMatrixWithConditions2392 obj = new BuildMatrixWithConditions2392();
        System.out.println(Arrays.deepToString(obj.buildMatrix(3, new int[][]{{1, 2}, {3, 2}}, new int[][]{{2, 1}, {3, 2}})));
//        System.out.println(Arrays.deepToString(obj.buildMatrix(3, new int[][]{{1, 2}, {2, 3}, {3, 1}, {2, 3}}, new int[][]{{2, 1}})));
    }

    public int kthSmallest(DeleteNodesReturnForest1110.TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        inOrder(root, queue, k);

        return queue.poll();
    }

    private void inOrder(DeleteNodesReturnForest1110.TreeNode root, Queue<Integer> queue, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, queue, k);
        queue.add(root.val);
        while (queue.size() > k) {
            queue.poll();
        }
        inOrder(root.right, queue, k);
    }


}
