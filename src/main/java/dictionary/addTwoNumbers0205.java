//面试题 02.05. 链表求和
//给定两个用链表表示的整数，每个节点包含一个数位。
//
//这些数位是反向存放的，也就是个位排在链表首部。
//
//编写函数对这两个整数求和，并用链表形式返回结果。
//
// 
//
//示例：
//
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//进阶：假设这些数位是正向存放的，请再做一遍。
//
//示例：
//
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sum-lists-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import LinkedList.ListNode;

public class addTwoNumbers0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        //进位
        int flag = 0;

        while (l1 != null || l2!= null){
            int sum = 0;
            if (l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }

            sum = sum + flag;
            int nowValue = sum% 10;
            flag = sum/10;
            ListNode cur = new ListNode(nowValue);
            tmp.next = cur;
            tmp = cur;
        }

        if (flag == 1){
            tmp.next = new ListNode(1);
        }

        return head.next;
    }
}
