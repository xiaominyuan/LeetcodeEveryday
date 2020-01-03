//19. 删除链表的倒数第N个节点

package ershua;

import LinkedList.ListNode;

public class removeNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode tmp = head;

        while (tmp != null){
            tmp = tmp.next;
            count++;
        }

        int count2 = count-n;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp2 = head;
        while (count2>0){
            tmp2 = tmp2.next;
            count2--;
        }

        tmp2.next = tmp2.next.next;

        return pre.next;
    }
}
