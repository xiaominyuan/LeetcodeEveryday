//86. 分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//你应当保留两个分区中每个节点的初始相对位置。
//
//示例:
//
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;


import java.awt.image.SampleModel;

//将小的放一个链表，大的放一个，最后把两个链表合起来
public class code86 {
    public ListNode partition(ListNode head, int x) {

        if (head == null){
            return head;
        }

        ListNode bigPre = new ListNode(0);
        ListNode smallPre = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);

        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        big.next = null;
        small.next = bigPre.next.next;

        return smallPre.next.next;


    }
}
