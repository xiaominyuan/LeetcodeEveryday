//199. 二叉树的右视图
//        给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//        示例:
//
//        输入: [1,2,3,null,5,null,4]
//        输出: [1, 3, 4]
//        解释:
//
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code199 {
    public Queue<TreeNode> queue = new LinkedList<TreeNode>();
    public List<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> ceng = new ArrayList<Integer>();



    public List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            List<Integer> list = new ArrayList<>();
            return list;
        }

        TreeNode last = root;
        TreeNode nextLast = null;

        queue.add(root);

        bfs(root,last,nextLast);

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i<all.size(); i++){
            result.add(all.get(i).get(all.get(i).size()-1));
        }

        return result;
    }

    public void bfs(TreeNode root, TreeNode last, TreeNode nextLast){
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
                all.add(ceng);
                last = nextLast;
                ceng = new ArrayList<Integer>();
            }

        }
    }
}
