//面试题28. 对称的二叉树
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
// 
//
//示例 1：
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//示例 2：
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

import DFS.TreeNode;

import java.util.Stack;

public class isSymmetric28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (right == null && left == null){
                continue;
            }

            if (right == null || left == null){
                return false;
            }

            if (right.val != left.val){
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
