package ershua;

import LinkedList.ListNode;

public class addTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        //进位数
        int next = 0;

        while (l1 != null || l2 != null){

            int x, y;
            if (l1 != null){
                x = l1.val;
            }else{
                x = 0;
            }

            if (l2 != null){
                y = l2.val;
            }else {
                y = 0;
            }

            int sum = next + x + y;

            cur.next = new ListNode(sum%10);
            next = sum/10;
            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }else{
                l2 = l2.next;
            }
        }

        if (next > 0){
            cur.next = new ListNode(next);
        }

        return pre.next;
    }
}
