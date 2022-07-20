package best.interview.questions.easy;

public class SortedArrayToBinaryTree {


    public static void main(String[] args) {
        SortedArrayToBinaryTree solution = new SortedArrayToBinaryTree();

        int[] nums = {-10,-3,0,5,9};
        System.out.println(solution.sortedArrayToBST(nums) + "\n");

        nums = new int[]{1, 3};
        System.out.println(solution.sortedArrayToBST(nums) + "\n");

        nums = new int[]{1};
        System.out.println(solution.sortedArrayToBST(nums));
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        int center = nums.length / 2;
        return new TreeNode(
                nums[center],
                sortedArrayToBST(nums, 0, center - 1),
                sortedArrayToBST(nums, center + 1, nums.length - 1)
        );
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int center = (left + right) / 2;
        return new TreeNode(
                nums[center],
                sortedArrayToBST(nums, left, center - 1),
                sortedArrayToBST(nums, center + 1, right)
        );
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
            return "TreeNode{" +
                    "val=" + val +"\n" +
                    ", left=" + left + "\n" +
                    ", right=" + right +
                    '}';
        }
    }


}
