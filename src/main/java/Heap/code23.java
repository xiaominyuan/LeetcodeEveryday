//23. 合并K个排序链表
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//示例:
//
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Heap;

import LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

//思路 ： 先用最小堆保存所有链表， 比较方法是按照链表头的大小，小的在顶堆
//   由于这些链表都是有序链表，所以链表头最小的那个节点一定是所有节点最小的
//   然后用tmp 节点指向这个最小头节点， 然后把剩余的链表在放进最小堆，不断弹出堆顶 就行了

public class code23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists){
            if (node != null){
                minHeap.add(node);
            }
        }

        ListNode pre = new ListNode(1);
        ListNode cur = new ListNode(1);
        pre.next = cur;

        while (!minHeap.isEmpty()){
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;

            if (tmp.next != null){
                minHeap.add(tmp.next);
            }
        }

        return pre.next.next;
    }
}
