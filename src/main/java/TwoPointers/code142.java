//142. 环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//说明：不允许修改给定的链表。
//
// 
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//floyd算法

//推导：
// 当快慢指针相遇时 ： 2(F + a) = F + 2a + b
//                         F = b

package TwoPointers;

import LinkedList.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class code142 {
    public ListNode detectCycle(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode fast = intersect(head);

        if (fast == null){
            return null;
        }

        while (head != fast){
            head = head.next;
            fast = fast.next;
        }

        return head;



    }

    public ListNode intersect(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return fast;
            }
        }

        return null;
    }


    //哈希表法
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head)){
                return head;
            }else{
                set.add(head);
            }

            head = head.next;
        }

        return null;
    }

}
