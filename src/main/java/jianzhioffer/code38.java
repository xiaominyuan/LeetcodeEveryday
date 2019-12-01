//删除链表中重复的结点
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5


package jianzhioffer;

import LinkedList.ListNode;

public class code38 {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode tmp = new ListNode(0);
        tmp.next = pHead;
        ListNode preLast = tmp;
        ListNode pre = pHead;

        while (pre != null){
            if (pre.next != null && pre.val == pre.next.val){
                while (pre.next != null && pre.val == pre.next.val){
                    pre = pre.next;
                }
                preLast.next = pre.next;
                pre = pre.next;
            }else{
                pre = pre.next;
                preLast = preLast.next;
            }
        }

        return tmp.next;
    }
}
