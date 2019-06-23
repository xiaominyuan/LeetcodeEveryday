//513. 找树左下角的值
//        给定一个二叉树，在树的最后一行找到最左边的值。
//
//        示例 1:
//
//        输入:
//
//        2
//        / \
//        1   3
//
//        输出:
//        1
//         
//
//        示例 2:
//
//        输入:
//
//        1
//        / \
//        2   3
//        /   / \
//        4   5   6
//        /
//        7
//
//        输出:
//        7
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



//和515的思路一样，都是采用广度优先算法进行层次遍历，将每各节点用二维list存起来

package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return 0;
        }

        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> ceng = new ArrayList<Integer>();

        TreeNode last = root;

        //下一层的最后一个节点
        TreeNode nextLast = null;

        queue.offer(root);

        while (!queue.isEmpty()){
            root = queue.poll();
            ceng.add(root.val);

            if (root.left != null){
                queue.offer(root.left);
                nextLast = root.left;
            }

            if (root.right != null){
                queue.offer(root.right);
                nextLast = root.right;
            }

            if (root == last){
                last = nextLast;
                result.add(ceng);
                ceng = new ArrayList<Integer>();
            }
        }

        List<Integer> resultSub = result.get(result.size()-1);
        return resultSub.get(0);
    }
}


//排名第一的解法：采用深度优先算法（前序遍历），并使用一个res记录当前层数，
//并使用层数判断是不是左节点
//public class Solution {
//    public int findBottomLeftValue(TreeNode root) {
//        return findBottomLeftValue(root, 1, new int[]{0,0});
//    }
//    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
//        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
//        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
//        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
//        return res[0];
//    }
//}
