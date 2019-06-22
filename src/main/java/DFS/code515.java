//515. 在每个树行中找最大值
//        您需要在二叉树的每一行中找到最大的值。
//
//        示例：
//
//        输入:
//
//        1
//        / \
//        3   2
//        / \   \
//        5   3   9
//
//        输出: [1, 3, 9]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package DFS;

import java.util.*;

public class code515 {
    //1.采用层次遍历，将每层的值存起来，最后找每层的最大值
    //2.采用层次遍历，每遍历一层的同时马上找最大值，直接存到maxlist,虽然执行用时还是很高。。。。
    public List<Integer> largestValues(TreeNode root) {

        ArrayList<Integer> maxList = new ArrayList<Integer>();

        if (root == null){
            return maxList;
        }

        // List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ceng = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        TreeNode last = root;
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

            if (last == root){
                last = nextLast;
                // result.add(ceng);
                maxList.add(Collections.max(ceng));
                ceng = new ArrayList<Integer>();

            }
        }



//         if (result.size() == 0){
//             return maxList;
//         }

//         for (int i = 0; i<result.size(); i++){
//             maxList.add(Collections.max(result.get(i)));
//         }
        return maxList;

    }
}

//排名第一的解法，dfs
//class Solution {
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        dfs(root, result, 0);
//        return result;
//    }
//    private void dfs(TreeNode node, List<Integer> result, int level) {
//        if(node == null) {
//            return;
//        }
//
//        if(level == result.size()) {
//            // expand result list to next level
//            result.add(node.val);
//        }
//        else {
//            // update max
//            result.set(level, Math.max(result.get(level), node.val));
//        }
//        dfs(node.left, result, level + 1);
//        dfs(node.right, result, level + 1);
//    }
//}