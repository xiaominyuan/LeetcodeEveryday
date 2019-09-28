//1038. 从二叉搜索树到更大和树
//给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
//
//提醒一下，二叉搜索树满足下列约束条件：
//
//节点的左子树仅包含键小于节点键的节点。
//节点的右子树仅包含键大于节点键的节点。
//左右子树也必须是二叉搜索树。
// 
//
//示例：
//
//
//
//输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

public class code1038 {
    //保存大节点的集合， 利用中序遍历的特点，逆向中序遍历
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if (node == null){
            return;
        }

        dfs(node.right);
        node.val = node.val + sum;
        sum = node.val;
        dfs(node.left);
    }
}
