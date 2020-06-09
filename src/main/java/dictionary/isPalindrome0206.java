//面试题 02.06. 回文链表
//编写一个函数，检查输入的链表是否是回文的。
//
// 
//
//示例 1：
//
//输入： 1->2
//输出： false
//示例 2：
//
//输入： 1->2->2->1
//输出： true
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import LinkedList.ListNode;

import java.util.List;

public class isPalindrome0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode mid = findMid(head);
        ListNode mid2 = reverse(mid.next);
        boolean res = true;
        while (mid2 != null){
            if (mid2.val != head.val){
                res = false;
            }
            if (res == false){
                break;
            }
            head = head.next;
            mid2 = mid2.next;
        }
        return res;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
