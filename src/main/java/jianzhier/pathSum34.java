//面试题34. 二叉树中和为某一值的路径
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
// 
//
//示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//返回:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        List<Integer> tmp = new ArrayList<>();
        help(result, tmp, root, sum);

        return result;

    }

    public void help(List<List<Integer>> result, List<Integer> tmp, TreeNode root, int target){
        tmp.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == target){
                result.add(tmp);
            }

            return;
        }


        //递归回退时， tmp已经添加的值无法回退，因为在上一个方法中定义的list
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.addAll(tmp);

        if (root.left != null){
            help(result, tmp, root.left, target-root.val);
        }

        if (root.right != null){
            help(result, tmp2, root.right, target-root.val);
        }

    }
}
