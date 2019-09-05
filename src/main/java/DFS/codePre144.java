//144. 二叉树的前序遍历

package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class codePre144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;

        while (cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }else {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return list;
    }
}
