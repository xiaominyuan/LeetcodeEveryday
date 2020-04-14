//1382. 将二叉搜索树变平衡
//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
//
//如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
//
//如果有多种构造方法，请你返回任意一种
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.ArrayList;

public class balanceBST1382 {
    ArrayList<TreeNode> list = null;
    TreeNode[] order = null;
    public TreeNode balanceBST(TreeNode root) {
        midDFS(root);
        order = list.toArray(new TreeNode[list.size()]);
        return build(0, order.length-1);
    }

    public TreeNode build(int left, int right){
        if (left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode tmp = order[mid];
        tmp.left = build(left, mid-1);
        tmp.right = build(mid +1, right);
        return tmp;
    }

    public void midDFS(TreeNode root){
        if (root == null){
            return;
        }
        midDFS(root.left);
        list.add(root);
        midDFS(root.right);
    }
}
