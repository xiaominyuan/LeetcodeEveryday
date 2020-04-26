//23. 合并K个排序链表
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//示例:
//
//输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package LinkedList;

public class mergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode tmp : lists){
            res = merge2Lists(tmp, res);
        }

        return res;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode tmp = pre;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }

            tmp = tmp.next;
        }

        if (l1 == null){
            tmp.next = l2;
        }else{
            tmp.next = l1;
        }

        return pre.next;
    }

}
