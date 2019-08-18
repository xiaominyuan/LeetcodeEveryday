//1019. 链表中的下一个更大节点
//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
//
//每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
//
//返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
//
//注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
//
// 
//
//示例 1：
//
//输入：[2,1,5]
//输出：[5,5,0]
//示例 2：
//
//输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
//示例 3：
//
//输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code1019 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        //从list末尾开始遍历，若栈中存在比当前值小的，之间弹出
        //否则直到遇到栈中第一个比这个list值大的元素，直接放到int数组中
        for (int i = list.size()-1; i>= 0; i--){
            while (!stack.empty() && stack.peek() <= list.get(i)){
                stack.pop();
            }

            if (stack.empty()){
                result[i] = 0;
            }else {
                result[i] = stack.peek();
            }

            //把当前的list值压入栈顶，给list前面的值比较
            stack.push(list.get(i));
        }

        return result;
    }
}
