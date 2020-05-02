//429. N叉树的层序遍历
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
//例如，给定一个 3叉树 :
//
// 
//
//
//
// 
//
//返回其层序遍历:
//
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i< size; i++){

                Node cur = queue.poll();
                tmp.add(cur.val);
                for (Node node : cur.children){
                    queue.add(node);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
