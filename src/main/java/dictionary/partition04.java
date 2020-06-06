//面试题 02.04. 分割链表
//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
//
//示例:
//
//输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-list-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import LinkedList.ListNode;

public class partition04 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode smallTmp = small;
        ListNode bigTmp = big;

        ListNode cur = head;
        while (cur != null){
            if (cur.val >= x){
                bigTmp.next = new ListNode(cur.val);
                bigTmp.next = bigTmp;
            }else{
                smallTmp.next = new ListNode(cur.val);
                smallTmp = smallTmp.next;
            }
        }
        smallTmp.next = big.next;
        return small.next;
    }
}
