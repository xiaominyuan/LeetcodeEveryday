//234. 回文链表
//请判断一个链表是否为回文链表。
//
//示例 1:
//
//输入: 1->2
//输出: false
//示例 2:
//
//输入: 1->2->2->1
//输出: true

package LinkedList;

public class code234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode slow = tmp;
        ListNode fast = tmp;

        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //将快指针作为慢指针的下一个，就算是奇数个节点， 那么后半段的节点比前半段少一个
        //如果是偶数个节点，那么前后半段的节点数一样
        fast = slow.next;
        //切断前后链表
        slow.next = null;
        slow = tmp.next;

        //开始反转后半段链表
        ListNode pre = null;
        while (fast != null){
            ListNode next = fast.next;
            fast.next = pre;
            pre = fast;
            fast = next;
        }

        while (pre != null){
            while (pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;

    }
}
