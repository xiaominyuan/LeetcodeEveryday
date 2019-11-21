//二叉树的最大深度
//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
// 最长路径的长度为树的深度。

package jianzhioffer;

import DFS.TreeNode;

public class code21 {
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
