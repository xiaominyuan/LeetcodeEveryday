//92. 反转链表 II
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
//示例:
//
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class code92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode start = pre;
        ListNode end = cur;
        ListNode third = null;

        while (n >0){
            third = cur.next;
            cur.next = pre;
            pre = cur;
            cur = third;
            n--;
        }

        if (start != null){
            start.next = pre;
        }else {
            head = pre;
        }

        end.next = cur;

        return head;
    }
}
