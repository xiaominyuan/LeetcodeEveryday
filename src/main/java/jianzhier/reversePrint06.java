//面试题06. 从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
//示例 1：
//
//输入：head = [1,3,2]
//输出：[2,3,1]

package jianzhier;

import LinkedList.ListNode;

import java.util.Stack;

public class reversePrint06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        int size = 0;
        while (tmp != null){
            stack.push(tmp.val);
            size++;
            tmp = tmp.next;
        }

        int[] res = new int[size];
        for (int i = 0; i< size; i++){
            res[i] = stack.pop();
        }

        return res;
    }
}
