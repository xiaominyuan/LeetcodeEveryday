//965. 单值二叉树
//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
//只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
// 
//
//示例 1：
//
//
//
//输入：[1,1,1,1,1,null,1]
//输出：true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/univalued-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.Stack;

public class code965 {

    //思路： 前序遍历二叉树进行判断
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        int flag = root.val;
        TreeNode cur = root;

        while (cur != null || !stack.empty()){
            if (cur != null){
                if (cur.val == flag){
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    return false;
                }
            }else {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return true;
    }
}
