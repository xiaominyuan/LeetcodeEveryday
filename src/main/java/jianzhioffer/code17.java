//从上往下打印二叉树

package jianzhioffer;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class code17 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode node = root;

        while (node != null || !queue.isEmpty()){
            if (node != null){
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
                node = queue.poll();
            }else{
                node = queue.poll();
            }
        }

        return list;
    }
}
