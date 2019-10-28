//102. 二叉树的层次遍历
//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()){

            //每一层的节点个数
            int counts = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i< counts; i++){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);

                if (tmp.left != null){
                    queue.add(tmp.left);
                }

                if (tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            res.add(list);
        }

        return res;
    }

}
