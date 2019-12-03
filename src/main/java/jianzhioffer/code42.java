//按之字形顺序打印二叉树
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

package jianzhioffer;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class code42 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (!s1.empty() || !s2.empty()){
            if (layer % 2 != 0){
                ArrayList<Integer> tmp = new ArrayList<>();

                while (!s1.empty()){
                    TreeNode node = s1.pop();
                    if (node != null){
                        tmp.add(node.val);
                        s2.add(node.left);
                        s2.add(node.right);
                    }
                }

                if (!tmp.isEmpty()){
                    res.add(tmp);
                    layer++;
                }
            }else{

                ArrayList<Integer> tmp = new ArrayList<>();
                while (!s2.empty()){
                    TreeNode node = s2.pop();
                    if (node != null){
                        tmp.add(node.val);
                        s1.add(node.right);
                        s1.add(node.left);
                    }
                }

                if (!tmp.isEmpty()){
                    res.add(tmp);
                    layer++;
                }
            }
        }

        return res;
    }
}
