//两个链表的第一个公共结点
//输入两个链表，找出它们的第一个公共结点。
package jianzhioffer;

import LinkedList.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code30 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        Map<ListNode, Integer> map = new HashMap<>();

        while (p1 != null){
            map.put(p1, 1);
            p1 = p1.next;
        }

        while (p2 != null){
            if (map.containsKey(p2)){
                return p2;
            }

            p2 = p2.next;
        }

        return null;
    }
}
