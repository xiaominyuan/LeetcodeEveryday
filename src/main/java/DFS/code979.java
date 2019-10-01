//979. 在二叉树中分配硬币
//给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
//
//在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
//
//返回使每个结点上只有一枚硬币所需的移动次数。
//
// 
//
//示例 1：
//
//
//
//输入：[3,0,0]
//输出：2
//解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
//示例 2：
//
//
//
//输入：[0,3,0]
//输出：3
//解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/distribute-coins-in-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

//思路 ： 后序遍历
public class code979 {

    public int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        result = result + Math.abs(left) + Math.abs(right);
        return root.val + left + right  - 1;
    }
}
