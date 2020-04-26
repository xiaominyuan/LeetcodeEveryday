//783. 二叉搜索树节点最小距离
//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
//
// 
//
//示例：
//
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import DFS.TreeNode;

import java.util.Stack;

public class minDiffInBST783 {
    TreeNode pre = null;
    Integer res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }

        dfs(root.left);
        if (pre != null){
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }

    public int minDiffInBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode pre = null;
        Integer res = Integer.MAX_VALUE;

        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if (pre != null){
                    res = Math.max(res, cur.val-pre.val);
                }
                pre = cur;
                cur = cur.right;

            }
        }

        return res;
    }

}
