//101. 对称二叉树

package ershua;

import DFS.TreeNode;

import java.util.Stack;

public class isSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }

    public boolean mirror(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }

        if (node1 == null || node2 == null){
            return false;
        }

        if (node1.val == node2.val){
            return mirror(node1.left, node2.right) && mirror(node1.right, node2.left);
        }else{
            return false;
        }
    }


    //非递归
    public boolean isSymmetric2(TreeNode root) {
        if (root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);

        while (!stack.isEmpty()){
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null){
                continue;
            }

            if (left == null || right == null){
                return false;
            }

            if (left.val != right.val){
                return false;
            }

            stack.push(right.right);
            stack.push(left.left);
            stack.push(right.left);
            stack.push(left.right);
        }

        return false;
    }
}
