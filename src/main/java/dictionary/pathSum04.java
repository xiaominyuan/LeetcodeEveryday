//面试题 04.12. 求和路径
//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
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
//3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import DFS.TreeNode;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class pathSum04 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return helper(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
    }

    public int helper(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        sum = sum - root.val;
        int count = 0;
        if (sum == 0){
            count = 1;
        }

        count = count + helper(root.left, sum);
        count = count + helper(root.right, sum);
        return count;
    }



    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        if (root == null){
            return 0;
        }

        return helper2(root, prefix, 0, sum);
    }

    public int helper2(TreeNode root, Map<Integer, Integer> prefix, int curSum, int sum){
        if (root == null){
            return 0;
        }

        curSum = curSum + root.val;
        int count = prefix.getOrDefault(curSum-sum, 0);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        count = count + helper2(root.left, prefix, curSum, sum);
        count = count + helper2(root.right, prefix, curSum, sum);
        prefix.put(curSum, prefix.getOrDefault(curSum, 0) - 1);
        return count;

    }
}
