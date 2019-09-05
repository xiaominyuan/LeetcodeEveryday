//145. 二叉树的后序遍历

package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class codePost145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        TreeNode prior = null;

        while (cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if (cur.right == null || cur.right == prior){
                    list.add(cur.val);
                    prior = cur;
                    cur = null;
                }else {
                    stack.push(cur);
                    cur = cur.right;
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        return list;
    }
}
