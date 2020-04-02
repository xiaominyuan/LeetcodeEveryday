//面试题32 - I. 从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
//返回：
//
//[3,9,20,15,7]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package jianzhier;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode cur = root;
        queue.add(cur);

        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null){
                queue.add(tmp.left);
            }

            if (tmp.right != null){
                queue.add(tmp.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i< list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
