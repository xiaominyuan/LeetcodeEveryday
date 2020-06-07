//面试题 04.03. 特定深度节点链表
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
// 
//
//示例：
//
//输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/list-of-depth-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import DFS.TreeNode;
import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class listOfDepth0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> list = new ArrayList<>();
        TreeNode cur = tree;
        queue.add(cur);

        while (!queue.isEmpty()){
            int size = queue.size();
            ListNode head = new ListNode(0);
            ListNode tmp = head;
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                ListNode node = new ListNode(poll.val);
                tmp.next = node;
                tmp = node;
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
            list.add(head.next);
        }

        return list.toArray(new ListNode[list.size()]);
    }
}
