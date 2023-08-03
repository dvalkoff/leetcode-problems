package best.interview.questions.medium;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> pathToTarget = getPathToTarget(root, target);
        int targetDepth = pathToTarget.size() - 1;
        for (int i = 0; i < pathToTarget.size(); i++) {
            TreeNode parent = pathToTarget.get(i);
            int parentDepth = pathToTarget.size() - i - 1;

            int depth = k + parentDepth - targetDepth;
            TreeNode exclude = i > 0 ? pathToTarget.get(i - 1) : null;
            List<Integer> descendants = findDescendants(parent, depth, exclude);
            result.addAll(descendants);
        }
        return result;
    }

    private List<Integer> findDescendants(TreeNode target, int k, TreeNode exclude) {
        if (k < 0) {
            return List.of();
        }
        if (k == 0) {
            return List.of(target.val);
        }

        List<TreeNode> result = List.of();
        List<TreeNode> nodes = List.of(target);
        while (k != 0) {
            List<TreeNode> descendants = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null && node.left != exclude) {
                    descendants.add(node.left);
                }
                if (node.right != null && node.right != exclude) {
                    descendants.add(node.right);
                }
            }
            nodes = descendants;
            k -= 1;
            if (k == 0) {
                result = nodes;
            }
        }
        return result.stream().map(node -> node.val).toList();

    }

    private List<TreeNode> getPathToTarget(TreeNode parent, TreeNode target) {
        if (parent == null) {
            return null;
        }
        if (parent == target) {
            List<TreeNode> result = new ArrayList<>();
            result.add(target);
            return result;
        }
        List<TreeNode> leftResult = getPathToTarget(parent.left, target);
        if (leftResult != null) {
            leftResult.add(parent);
            return leftResult;
        }
        List<TreeNode> rightResult = getPathToTarget(parent.right, target);
        if (rightResult != null) {
            rightResult.add(parent);
            return rightResult;
        }
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
