//1026. 节点与其祖先之间的最大差值
//给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
//
//        （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
//
//         
//
//        示例：
//
//
//
//        输入：[8,3,10,1,6,null,14,null,null,4,7,13]
//        输出：7
//        解释：
//        我们有大量的节点与其祖先的差值，其中一些如下：
//        |8 - 3| = 5
//        |3 - 7| = 4
//        |8 - 1| = 7
//        |10 - 13| = 3
//        在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



package DFS;

public class code1026 {
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        find(root, root.val, root.val);
        return max;
    }

    public void find(TreeNode node, int maxs, int mins){
        if (node == null){
            return;
        }
        int max_tmp = Math.max(maxs, node.val);
        int min_tmp= Math.min(mins, node.val);
        max = Math.max(max, Math.max(Math.abs(max_tmp-node.val),Math.abs(min_tmp-node.val)));
        find(node.left, max_tmp, min_tmp);
        find(node.right,max_tmp, min_tmp);
    }
}
