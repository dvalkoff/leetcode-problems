package best.interview.questions.easy;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                        ),
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(3)

                )
        );
        System.out.println(symmetricTree.isSymmetric(root));

        root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(
                        2,
                        null,
                        new TreeNode(3)
                )
        );
        System.out.println(symmetricTree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
