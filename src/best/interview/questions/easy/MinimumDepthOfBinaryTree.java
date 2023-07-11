package best.interview.questions.easy;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left == null) {
            return minDepthRecursive(root.right) + 1;
        }
        if (root.right == null) {
            return minDepthRecursive(root.left) + 1;
        }
        return Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
    }


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
    }
}
