//222. 完全二叉树的节点个数
//给出一个完全二叉树，求出该树的节点个数。
//
//说明：
//
//完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
//
//示例:
//
//输入:
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package BinarySearch;

import DFS.TreeNode;

public class code222 {
    //普通方法
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //利用完全二叉树的性质，节点个数 = 2^(树高) - 1 左右树高相等的情况下
    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root;
        TreeNode right = root;

        while (left != null){
            left = left.left;
            leftHeight++;
        }

        while (right != null){
            right = right.right;
            rightHeight++;
        }

        if (rightHeight == leftHeight){
            return (int) Math.pow(2, leftHeight) -1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
