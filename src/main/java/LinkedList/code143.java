//143. 重排链表
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例 1:
//
//给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//示例 2:
//
//给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reorder-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;

public class code143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next != null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        //找中点
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        ListNode cur = slow.next;

        //原地翻转中点之后的链表
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }

        ListNode p1 = head;
        ListNode p2 = slow.next;

        while (p1 != slow){
            slow.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = slow.next;
        }
    }
}
