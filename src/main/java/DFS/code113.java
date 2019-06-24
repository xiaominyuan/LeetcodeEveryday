//113.路径总和 II
//        给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/path-sum-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package DFS;

import java.util.ArrayList;
import java.util.List;

public class code113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(result, tmp, root, sum);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tmp, TreeNode root, int sum){
        if (root == null){
            return;
        }

        tmp.add(root.val);

        if (root.val == sum && root.left ==null && root.right == null){
            result.add(new ArrayList(tmp));
        }

        dfs(result, tmp, root.left,sum-root.val);
        dfs(result, tmp, root.right, sum-root.val);
        //回溯时将节点删除
        tmp.remove(tmp.size()-1);
    }
}
