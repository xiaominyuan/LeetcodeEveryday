//148. 排序链表
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//示例 1:
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2:
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sort-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class code148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode[] count = new ListNode[64];
        ListNode curNode = head;
        int maxIndex = 0;

        while (curNode != null){
            ListNode carryNode = curNode;
            curNode = curNode.next;
            carryNode.next = null;

            int i = 0;
            while (count[i] != null){
                ListNode mergeNode = mergeTwo(count[i], carryNode);
                count[i] = null;
                i++;
                carryNode = mergeNode;
            }

            count[i] = carryNode;

            if (maxIndex < i){
                maxIndex = i;
            }
        }

        ListNode res = null;

        for (int i = 0; i<=maxIndex; i++){
            res = mergeTwo(res, count[i]);
        }

        return res;
    }


    //通用方法：有序合并两个链表
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }
}
