//面试题55 - II. 平衡二叉树

package DFS;

public class isBalanced55 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1){
            return false;
        }else{
            //判断根节点之后，还需要递归地判断每个节点的左右子树
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    //返回左右子树中最大的高度
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right);
    }
}
