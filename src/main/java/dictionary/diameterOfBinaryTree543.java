//543. 二叉树的直径
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
//示例 :
//给定二叉树
//
//          1
//         / \
//        2   3
//       / \
//      4   5
//返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import DFS.TreeNode;



//思路： 遍歷每個節點，求每个节点的左右深度之和，再比较max
public class diameterOfBinaryTree543 {
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        dfs(root);
        return max;

    }

    public int dfs(TreeNode root){
        if (root.left == null && root.right == null){
            return 0;
        }

        int leftDepth = 0;
        if (root.left == null){
            leftDepth = 0;
        }else{
            leftDepth = dfs(root.left) + 1;
        }

        int rightDepth = 0;
        if (root.right == null){
            rightDepth = 0;
        }else{
            rightDepth = dfs(root.right) + 1;
        }

        max = Math.max(leftDepth+rightDepth, max);
        return Math.max(leftDepth, rightDepth);
    }
}
