//对称的二叉树
//请实现一个函数，用来判断一颗二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

package jianzhioffer;

import DFS.TreeNode;

import java.util.Stack;

public class code41 {
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null){
                continue;
            }

            if (left == null || right == null){
                return false;
            }

            if (left.val != right.val){
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}
