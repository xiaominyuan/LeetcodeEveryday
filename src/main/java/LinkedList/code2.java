//2. 两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/add-two-numbers
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;

public class code2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode pre = new ListNode(0);
        ListNode tmp = pre;

        //表示进位数
        int carry = 0;
        while (a != null || b != null){
            int x;
            int y;

            if (a != null){
                x = a.val;
            }else {
                x = 0;
            }

            if (b != null){
                y = b.val;
            }else{
                y = 0;
            }

            int sums = carry + x + y;
            carry = sums/10;

            tmp.next = new ListNode(sums%10);
            tmp = tmp.next;

            if (a != null){
                a = a.next;
            }

            if (b != null){
                b = b.next;
            }

        }

        if (carry > 0){
            tmp.next = new ListNode(carry);
        }

        return pre.next;
    }
}
