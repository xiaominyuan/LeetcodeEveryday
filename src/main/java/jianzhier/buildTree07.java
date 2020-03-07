//面试题07. 重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

import DFS.TreeNode;

import java.util.Stack;

public class buildTree07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);

        stack.push(root);
        int inOrderIndex = 0;

        for (int i = 1; i< preorder.length; i++){
            int preOrderValue = preorder[i];
            TreeNode node = stack.peek();

            if (node.val != inorder[inOrderIndex]){
                node.left = new TreeNode(preOrderValue);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]){
                    node = stack.pop();
                    inOrderIndex++;
                }

                node.right = new TreeNode(preOrderValue);
                stack.push(node.right);

            }
        }

        return root;
    }
}
