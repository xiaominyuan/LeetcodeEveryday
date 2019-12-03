//二叉搜索树的第k个结点
//给定一棵二叉搜索树，请找出其中的第k小的结点。
// 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

package jianzhioffer;

import DFS.TreeNode;

import java.util.Stack;

//二叉搜索树按照中序遍历就是从小到大打印

public class code44 {
    public TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null || k == 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        int count = 0;
        TreeNode cur = pRoot;

        while (pRoot != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                count++;
                if (count == k){
                    return cur;
                }
                cur = cur.right;
            }
        }

        return null;
    }
}
