// 相似的企业真题
//时间限制：1秒 空间限制：32768K 热度指数：258958
//本题知识点： 树
// 算法知识视频讲解
//题目描述
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//笔记
//收藏
//纠错
//平衡二叉树
//

package jianzhioffer;

import DFS.TreeNode;

public class code32 {
    //每个子树都求深度
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    //方法2 避免重复遍历, 自底向上
    private boolean flag = true;

    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null){
            return true;
        }
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1){
            flag = false;
        }

        if (right > left){
            return right + 1;
        }else {
            return left + 1;
        }
    }
}
