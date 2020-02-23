//面试题55 - II. 平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回 true 。


package jianzhier;

import DFS.TreeNode;

public class pinghengerchashu55 {

    public boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        help(root);
        return flag;
    }

    public int help(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = help(root.left) + 1;
        int right = help(root.right) + 1;

        if (Math.abs(left-right) > 1){
            flag = false;
        }

        return Math.max(left, right);
    }
}
