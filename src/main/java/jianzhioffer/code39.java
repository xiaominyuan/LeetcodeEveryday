//链表中环的入口结点
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

package jianzhioffer;

import LinkedList.ListNode;

public class code39 {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        if (fast == null || fast.next == null){
            return null;
        }

        slow = pHead;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
