package leetcode.solutions;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class CreateBinaryTreeFromDesc2196 {

    public class TreeNode {
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
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDesc2196 binaryTreeFromDesc = new CreateBinaryTreeFromDesc2196();

        System.out.println(binaryTreeFromDesc.createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));
        System.out.println(binaryTreeFromDesc.createBinaryTree1(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));
    }

    // Size is 10^4 so we can use array instead of map.
    public TreeNode createBinaryTree1(int[][] descriptions) {
        TreeNode[] nodes = new TreeNode[100001];
        boolean[] child = new boolean[100001];
        for (int[] description : descriptions) {

            if (nodes[description[0]] == null) {
                nodes[description[0]] = new TreeNode(description[0]);
            }
            if (nodes[description[1]] == null) {
                nodes[description[1]] = new TreeNode(description[1]);
            }
            if (description[2] == 1) {
                nodes[description[0]].left = nodes[description[1]];
            } else {
                nodes[description[0]].right = nodes[description[1]];
            }
            child[description[1]] = true;
        }

        for (int i = 0; i < child.length; i++) {
            if (!child[i] && nodes[i] != null) {
                return nodes[i];
            }
        }
        return null;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> noOfParents = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();
        for (int[] description : descriptions) {
            TreeNode parent = map.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));

            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            noOfParents.put(description[1], noOfParents.getOrDefault(description[1], 0) + 1);
            noOfParents.put(description[0], noOfParents.getOrDefault(description[0], 0));
            map.put(description[0], parent);
            map.put(description[1], child);
            childNodes.add(description[1]);
        }
        Integer parent = map.keySet().stream().filter(Predicate.not(childNodes::contains)).findFirst().get();

        return map.get(parent);
    }
}
