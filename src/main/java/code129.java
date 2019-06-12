//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//        例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//        计算从根到叶子节点生成的所有数字之和。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//
//        输入: [1,2,3]
//        1
//        / \
//        2   3
//        输出: 25
//        解释:
//        从根到叶子节点路径 1->2 代表数字 12.
//        从根到叶子节点路径 1->3 代表数字 13.
//        因此，数字总和 = 12 + 13 = 25.

public class code129 {
    public int sumNumbers(TreeNode root) {
        if (root != null){
            return sumDFS(root,0);
        }else{
            return 0;
        }
    }

    public int sumDFS(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        sum = sum*10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }
        return sumDFS(root.left, sum) + sumDFS(root.right, sum);
    }
}
