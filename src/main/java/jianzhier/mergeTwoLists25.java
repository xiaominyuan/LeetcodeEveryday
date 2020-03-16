//面试题25. 合并两个排序的链表

package jianzhier;

import LinkedList.ListNode;

import java.util.List;

public class mergeTwoLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }

        return res.next;
    }
}
