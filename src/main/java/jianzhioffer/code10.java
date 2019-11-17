package jianzhioffer;

import DFS.ListNode;

public class code10 {
    public ListNode FindKthToTail(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        while (p != null){
            count = count + 1;
            p = p.next;
        }

        int len = count - k;

        if (len < 0){
            return null;
        }

        p = tmp;

        while (len > 0){
            p = p.next;
            len = len - 1;
        }

        return p.next;



    }
}
