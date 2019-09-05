//94. 二叉树的中序遍历

package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class codeMiddle94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;

        while (root != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
