//112. 路径总和
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
//说明: 叶子节点是指没有子节点的节点。
//
//示例: 
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/path-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class code112 {

    //递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        return find(root, sum);
    }

    public boolean find(TreeNode node, int sum){
        if (node.left == null && node.right == null && sum == node.val){
            return true;
        }

        if (node.left != null){
            return find(node.left, sum - node.val);
        }

        if (node.right != null){
            return find(node.right, sum - node.val);
        }

        return false;
    }

    //bfs
    public boolean hasPathSum2(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();

        if (root == null){
            return false;
        }

        queue.add(root);
        queueSum.add(root.val);

        while (!queue.isEmpty()){
            int counts = queue.size();
            for (int i = 0; i< counts; i++){
                TreeNode tmpNode = queue.poll();
                int tmpSum = queueSum.poll();
                if (tmpNode.left == null && tmpNode.right == null && tmpSum == sum){
                    return true;
                }

                if (tmpNode.left != null){
                    queue.add(tmpNode.left);
                    queueSum.add(tmpSum + tmpNode.left.val);
                }

                if (tmpNode.right != null){
                    queue.add(tmpNode.right);
                    queueSum.add(tmpSum + tmpNode.right.val);
                }
            }
        }

        return false;
    }

    //dfs
    public boolean hasPathSum3(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();

        TreeNode cur = root;
        int curSum = 0;

        while (cur != null || !stack.isEmpty()){
            while (cur.left != null){
                stack.push(cur);
                curSum = curSum + cur.val;
                stackSum.push(curSum);
                cur = cur.left;
            }

            cur = stack.pop();
            curSum = stackSum.pop();

            if (curSum == sum && cur.left == null && cur.right == null){
                return true;
            }

            cur = cur.right;
        }

        return false;
    }

}
