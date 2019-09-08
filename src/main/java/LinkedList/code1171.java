//1171. 从链表中删去总和值为零的连续节点
//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
//
//删除完毕后，请你返回最终结果链表的头节点。
//
// 
//
//你可以返回任何满足题目要求的答案。
//
//（注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
//
//示例 1：
//
//输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
//示例 2：
//
//输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
//示例 3：
//
//输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;

public class code1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode pre = null;
        ListNode start = head;

        while (start != null){
            int sum = start.val;
            ListNode next = start.next;

            while (sum != 0){
                if (next != null){
                    sum = sum + next.val;
                    next = next.next;
                }else{
                    //找到了就结束循环
                    break;
                }
            }

            if (sum == 0){

                if (head == start){
                    head = next;
                }else {
                    pre.next = next;
                }
                start = next;

            }else{
                //这个节点遍历完没有，两个指针右移
                pre = start;
                start = start.next;
            }
        }

        return head;
    }
}
