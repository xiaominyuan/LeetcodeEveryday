//141. 环形链表
//给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/linked-list-cycle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;


import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class code141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){

            //如果没有换，快的指针会走到尽头
            if (fast == null || fast.next == null){
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        //当两个指针相遇，就是有环
        return true;
    }


    //哈希表法
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
            }

            head = head.next;
        }

        return false;
    }
}
