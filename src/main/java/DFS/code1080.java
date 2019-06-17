//1080. 根到叶路径上的不足节点
//        给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
//
//        假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
//
//        请你删除所有不足节点，并返回生成的二叉树的根。
package DFS;

public class code1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean flag = backSortDFS(root, 0, limit);
        if (flag){
            return null;
        }
        return root;
    }

    public boolean backSortDFS(TreeNode node, int sum, int limit){
        if (node.left == null && node.right == null){
            return (sum + node.val < limit);
        }

        boolean leftDeleteNode = true;
        boolean rightDeleteNode = true;

        if (node.left != null){
            leftDeleteNode = backSortDFS(node.left, sum+node.val, limit);
        }

        if (node.right != null){
            rightDeleteNode = backSortDFS(node.right, sum+node.val, limit);
        }

        if (leftDeleteNode == true){
            node.left = null;
        }

        if (rightDeleteNode == true){
            node.right = null;
        }
        //如果左右子节点都需要删除，这个父节点需要删除（置为null）
        return leftDeleteNode && rightDeleteNode;
    }
}
