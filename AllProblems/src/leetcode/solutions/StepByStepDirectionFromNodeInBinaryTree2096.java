package leetcode.solutions;

public class StepByStepDirectionFromNodeInBinaryTree2096 {

    public static void main(String[] args) {
        //  5,1,2,3,null,6,4
        StepByStepDirectionFromNodeInBinaryTree2096 directions = new StepByStepDirectionFromNodeInBinaryTree2096();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1, new TreeNode(3), null);
        node.right = new TreeNode(2, new TreeNode(6), new TreeNode(4));
        System.out.println(directions.getDirections(node, 3, 6));
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {


        StringBuilder sourcePath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        findTarget(root, startValue, sourcePath);
        findTarget(root, destValue, destPath);

        StringBuilder ans = new StringBuilder();
        int common = 0;
        while (common < sourcePath.length() && common < destPath.length()
                && sourcePath.charAt(common) == destPath.charAt(common)) {
            common++;
        }

        for (int i = 0; i < sourcePath.length() - common; i++) {
            ans.append("U");
        }

        // Add directions from common ancestor to destination
        for (int i = common; i < destPath.length(); i++) {
            ans.append(destPath.charAt(i));
        }

        return ans.toString();
    }

    public boolean findTarget(TreeNode root, int target, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }

        sb.append("L");
        if (findTarget(root.left, target, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append("R");
        if (findTarget(root.right, target, sb)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
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
    }
}
