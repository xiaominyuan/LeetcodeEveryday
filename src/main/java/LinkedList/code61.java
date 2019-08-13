package LinkedList;

public class code61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        //将链表变成一个闭环，然后旋转
        int n;
        ListNode tmp = head;
        for (n = 1; tmp.next != null; n++){
            tmp = tmp.next;
        }

        ListNode end = head;
        for (int i = 0; i< (n-k%n-1); i++){
            end = end.next;
        }

        ListNode start = end.next;

        //切断闭环
        end.next = null;

        return start;
    }
}
