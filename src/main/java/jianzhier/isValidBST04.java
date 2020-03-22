//面试题 04.05. 合法二叉搜索树
//实现一个函数，检查一棵二叉树是否为二叉搜索树。
//
//示例 1:
//输入:
//    2
//   / \
//  1   3
//输出: true
//示例 2:
//输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//通过次数1,256提交次数3,445
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package jianzhier;

import DFS.TreeNode;

import java.util.Stack;

public class isValidBST04 {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if (root.left == null && root.right == null){
            return true;
        }

        long pre = Long.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if (cur.val > pre){
                    pre = cur.val;
                }else{
                    return false;
                }
                cur = cur.right;
            }
        }

        return false;
    }
}
