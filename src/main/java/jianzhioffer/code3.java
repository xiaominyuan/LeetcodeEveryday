package jianzhioffer;

import DFS.TreeNode;

import java.util.Arrays;

public class code3 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0){
            return null;
        }

        int rootVal = pre[0];

        if (pre.length == 1){
            return new TreeNode(rootVal);
        }

        int index = 0;
        TreeNode root = new TreeNode(rootVal);

        for (int i = 0; i< in.length; i++){
            if (in[i] == rootVal){
                index = i;
                break;
            }
        }

        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index+1, pre.length), Arrays.copyOfRange(in, index+1, in.length));
        return root;
    }
}
