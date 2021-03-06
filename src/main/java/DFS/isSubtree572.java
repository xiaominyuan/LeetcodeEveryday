//572. 另一个树的子树
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
//示例 1:
//给定的树 s:
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//给定的树 t：
//
//   4
//  / \
// 1   2
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subtree-of-another-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

public class isSubtree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        }

        if (s == null || t == null){
            return false;
        }

        if (s != null && t != null){
            if (isSame(s, t)){
                return true;
            }

            if (isSubtree(s.left, t)){
                return true;
            }

            if (isSubtree(s.right, t)){
                return true;
            }
        }

        return false;
    }

    public boolean isSame(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }

        if (t1 == null || t2 == null){
            return false;
        }

        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
