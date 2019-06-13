//给定一个二叉树，原地将它展开为链表。
//
//        例如，给定二叉树
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        将其展开为：
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
//后序遍历,,在还没操作节点右子树前，不能破坏该节点的右子树指向。所以采用后序遍历。

import java.util.Stack;

public class code114 {
//    public void flatten(TreeNode root){
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//
//            if (!stack.isEmpty()){
//                TreeNode node = stack.pop();
//                TreeNode tmp = node.right;
//                node.right = node.left;
//                node.left = null;
//                while (node.right != null){
//                    node = node.right;
//                }
//                node.right = tmp;
//                root = tmp;
//            }
//        }
//    }
    public void flatten(TreeNode root){
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = tmp;
    }
}
