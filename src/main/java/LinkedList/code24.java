//24. 两两交换链表中的节点
//        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//         
//
//        示例:
//
//        给定 1->2->3->4, 你应该返回 2->1->4->3.
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class code24 {
    public ListNode swapPairs(ListNode head) {
            //非递归

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;

        while (tmp.next != null && tmp.next.next != null){
            ListNode start = pre.next;
            ListNode end = pre.next.next;

            //改变链表指针指向
            tmp.next = end;
            start.next = end.next;
            end.next = start;

            tmp = start;
        }

        return pre.next;
    }

    public ListNode swapPairs2(ListNode head) {
        //递归

        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;

        return next;
    }
}
