package leetcode.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeleteNodesReturnForest1110 {

    public static void main(String[] args) {
        //  1, 2, 3, 4, 5, 6, 7
        DeleteNodesReturnForest1110 input = new DeleteNodesReturnForest1110();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        node.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        System.out.println(input.delNodes(node, new int[]{3, 5}));
    }

    Map<Integer, TreeNode> parents = new HashMap<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();
    List<Integer> rootToLeafNodes = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (to_delete.length == 0) {
            return List.of(root);
        }
        findParents(root);

        Set<Integer> nodesToDelete = new HashSet<>();
        List<Integer> nodesToDeleteList = new ArrayList<>();
        for(int val: to_delete) {
            nodesToDelete.add(val);
        }
        if (nodesToDelete.contains(root.val)) {
            ans.add(root.left);
            ans.add(root.right);
            nodesToDelete.remove(root.val);
        } else {
            ans.add(root);
        }
        for (Integer node: rootToLeafNodes) {
            if (nodesToDelete.contains(node)) {
                nodesToDeleteList.add(node);
            }
        }

        Collections.reverse(nodesToDeleteList);
        System.out.println(nodesToDeleteList);
        for(Integer val: nodesToDeleteList) {
            TreeNode node = nodes.get(val);
            TreeNode parent = parents.get(node.val);

            if (parent.left != null && parent.left.val == node.val) {
                parent.left = null;
            } else if (parent.right != null && parent.right.val == node.val) {
                parent.right = null;
            }
            if (node.left == null && node.right == null) {
                nodes.remove(node.val);
                parents.remove(node.val);
            } else {
                if (node.left != null) {
                    ans.add(node.left);
                }
                if (node.right != null) {
                    ans.add(node.right);
                }
            }
        }

        return ans;
    }

    private void findParents(TreeNode root) {
        if (root == null) {
            return;
        }
        nodes.put(root.val, root);
        rootToLeafNodes.add(root.val);
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(root.right);
        }
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
//                    "TreeNode{" +
                    "val=" + val +
//                    ", left=" + left +
//                    ", right=" + right +
//                    '}';
                    '\n';
        }
    }
}
