//面试题 04.08. 首个共同祖先
//设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
//
//例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//    3
//   / \
//  5   1
// / \ / \
//6  2 0  8
//  / \
// 7   4
//示例 1:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import DFS.TreeNode;

public class lowestCommonAncestor08 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null){
            return rightNode;
        }
        if (rightNode == null){
            return leftNode;
        }
        return root;
    }
}
