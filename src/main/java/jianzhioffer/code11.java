//反转链表
package jianzhioffer;

import LinkedList.ListNode;

public class code11 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;

        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }
}
