//637. 二叉树的层平均值
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
//
//示例 1:
//
//输入:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出: [3, 14.5, 11]
//解释:
//第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package DFS;

import java.util.*;

public class code637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return list;
        }

        queue.add(root);

        while (!queue.isEmpty()){
            double sum = 0.0;
            int count = queue.size();

            for (int i = 0; i<count; i++){
                TreeNode node = queue.poll();
                sum = sum + node.val;

                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }

            if (count > 0){
                list.add(sum/count);
            }

        }

        return list;
    }
}
