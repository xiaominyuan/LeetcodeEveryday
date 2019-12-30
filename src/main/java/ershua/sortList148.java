//148. 排序链表
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//示例 1:
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2:
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sort-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package ershua;

import DFS.ListNode;

public class sortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }

        if (head.next == null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        head = sortList(head);
        fast = sortList(fast);
        ListNode res = merge(head, fast);
        return res;

    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode head;
        if (left.val <= right.val){
            head = left;
            left = left.next;
        }else {
            head = right;
            right = right.next;
        }


        ListNode tmp = head;
        while (left != null && right != null){
            if (left.val <= right.val){
                tmp.next = left;
                left = left.next;
                tmp = tmp.next;
            }else{
                tmp.next = right;
                right = right.next;
                tmp = tmp.next;
            }
        }

        if (left == null){
            tmp.next = right;
        }

        if (right == null){
            tmp.next = left;
        }

        return head;
    }
}
