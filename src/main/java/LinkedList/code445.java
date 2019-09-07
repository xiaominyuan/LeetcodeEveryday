//445. 两数相加 II
//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//
// 
//
//你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//进阶:
//
//如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//示例:
//
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/add-two-numbers-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;

import java.util.Stack;

public class code445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode tmp1 = l1;
        while (tmp1 != null){
            stack1.push(tmp1.val);
            tmp1 = tmp1.next;
        }

        ListNode tmp2 = l2;
        while (tmp2 != null){
            stack2.push(tmp2.val);
            tmp2 = tmp2.next;
        }

        //进位
        int flag = 0;
        ListNode head = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0){
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 :stack2.pop();

            int sum = num1+num2+flag;
            ListNode node = new ListNode(sum%10);
            flag = sum /10;
            node.next = head;
            head = node;
        }

        return head;
    }
}
