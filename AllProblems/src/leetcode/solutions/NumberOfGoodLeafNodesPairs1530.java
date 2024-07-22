package leetcode.solutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfGoodLeafNodesPairs1530 {

    Map<TreeNode, String> distanceFromSource = new HashMap<>();

    public static void main(String[] args) {
        //  5,1,2,3,null,6,4
        NumberOfGoodLeafNodesPairs1530 leafNodesCount = new NumberOfGoodLeafNodesPairs1530();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        node.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        System.out.println(leafNodesCount.countPairs(node, 3));

//        System.out.println(leafNodesCount.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
    }

    public int countPairs(TreeNode root, int distance) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        findAllLeafNodes(root, new StringBuilder());
        System.out.println("distanceFromSource: " + distanceFromSource);

        Set<TreeNode> list = distanceFromSource.keySet();
        for (TreeNode node : list) {
            for (Map.Entry<TreeNode, String> entry : distanceFromSource.entrySet()) {
                if (node.equals(entry.getKey())) {
                    continue;
                }
                TreeNode targetNode = entry.getKey();
                String source = distanceFromSource.get(node);
                String target = distanceFromSource.get(targetNode);
                int i = 0, count = 0;
                while (i < source.length() && i < target.length()) {
                    if (source.charAt(i) == target.charAt(i)) {
                        count++;
                        i++;
                    } else {
                        break;
                    }
                }
                int dist = source.length() - count + target.length() - count;
                if (dist <= distance) {
                    System.out.println("PAIRRR: " + source + ", " + target);
                    System.out.println("PAIR: " + node + ", " + targetNode);
                    ans++;
                }
            }
        }

        return ans / 2;
    }

    private boolean findAllLeafNodes(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            distanceFromSource.put(root, sb.toString());
            return true;
        }

        if (root.left != null) {
            sb.append("L");
            findAllLeafNodes(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            sb.append("R");
            findAllLeafNodes(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return
                    "TreeNode{" +
                            "val=" + val +
                            ", left=" + left +
                            ", right=" + right +
                            '}';
        }
    }
}
