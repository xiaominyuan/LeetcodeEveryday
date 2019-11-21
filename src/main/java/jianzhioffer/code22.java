//二叉树的最小深度

package jianzhioffer;

import DFS.TreeNode;

public class code22 {
    public int TreeDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null){
            minDepth = Math.min(TreeDepth2(root.left), minDepth);
        }

        if (root.right != null){
            minDepth = Math.min(TreeDepth2(root.right), minDepth);
        }

        return minDepth+1;
    }
}
