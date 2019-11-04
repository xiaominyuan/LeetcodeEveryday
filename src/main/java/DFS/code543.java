//543. 二叉树的直径
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
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
//注意：两结点之间的路径长度是以它们之间边的数目表示。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

public class code543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

}
