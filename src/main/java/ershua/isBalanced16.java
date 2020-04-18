//110. 平衡二叉树
package ershua;

import DFS.TreeNode;

public class isBalanced16 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = height(node.left)+1;
        int right = height(node.right)+1;
        if (left > right){
            return left +1;
        }else{
            return right+1;
        }
    }
}
