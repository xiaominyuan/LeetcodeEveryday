//147. 对链表进行插入排序
//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
// 
//
//插入排序算法：
//
//插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//重复直到所有输入数据插入完为止。
// 
//
//示例 1：
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2：
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/insertion-sort-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class code147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head != null && head.next != null){

            //找到前部分排序好的部分最后一个数字， head
            if (head.val <= head.next.val){
                head = head.next;
                continue;
            }

            ListNode pre = dummy;

            //找到需要插入的位置，pre.next
            while (pre.next.val <= head.next.val){
                pre = pre.next;
            }

            //将后半部分未排好序的部分第一个数字，拿出来 cur
            ListNode cur = head.next;
            head.next = cur.next;

            //将cur 插入，并改变插入后的指向顺序
            cur.next = pre.next;
            pre.next = cur;
        }

        return dummy.next;
    }
}
