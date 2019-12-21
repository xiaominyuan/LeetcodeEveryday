//98. 验证二叉搜索树

package ershua;

import DFS.TreeNode;

import java.util.Stack;

public class isValidBST98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if (pre != null && cur.val <= pre.val){
                    return false;
                }

                pre = cur;
                cur = cur.right;
            }
        }

        return true;
    }
}
