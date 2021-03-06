//61. 旋转链表
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/rotate-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class code61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        //将链表变成一个闭环，然后旋转
        int n;
        ListNode tmp = head;
        for (n = 1; tmp.next != null; n++){
            tmp = tmp.next;
        }

        ListNode end = head;
        for (int i = 0; i< (n-k%n-1); i++){
            end = end.next;
        }

        ListNode start = end.next;

        //切断闭环
        end.next = null;

        return start;
    }
}
