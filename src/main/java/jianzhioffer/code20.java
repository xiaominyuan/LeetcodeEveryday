//二叉树中和为某一值的路径
//输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

package jianzhioffer;

import DFS.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class code20 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        find(result, tmp, root, target);
        return result;
    }

    public void find(ArrayList<ArrayList<Integer>> total, ArrayList<Integer> tmp, TreeNode root, int target){
        tmp.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == target){
                total.add(tmp);
            }

            return;
        }

        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp2.addAll(tmp);

        if (root.left != null){
            find(total, tmp, root.left, target - root.val);
        }

        if (root.right != null){
            find(total, tmp2, root.right, target - root.val);
        }
    }


}
