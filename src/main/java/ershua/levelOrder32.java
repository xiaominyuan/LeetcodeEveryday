//面试题32 - II. 从上到下打印二叉树 II
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
// 
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
//链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i>0; i--){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
