//82. 删除排序链表中的重复元素 II
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//示例 1:
//
//输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//示例 2:
//
//输入: 1->1->1->2->3
//输出: 2->3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;


//三指针
public class code82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null){
            ListNode a = cur.next;
            ListNode b = cur.next.next;

            if (a.val == b.val){

                //b 指针寻找连续的相同值，直到找不到了，直接删除
                while (b != null && a.val == b.val){
                    b = b.next;
                }

                //删除相同的数
                cur.next = b;
            }else {
                cur = cur.next;
            }

        }

        return dummy.next;
    }
}
