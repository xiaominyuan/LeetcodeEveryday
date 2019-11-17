//合并两个排序的链表
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

package jianzhioffer;

import LinkedList.ListNode;

public class code12 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode root = head;

        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                head.next = list1;
                head = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            head.next = list1;
        }

        if (list2 != null){
            head.next = list2;
        }

        return root.next;

    }
}
