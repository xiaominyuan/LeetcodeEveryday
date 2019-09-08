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

import java.util.HashMap;
import java.util.Map;

public class code1171 {

    //暴力遍历
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


    //用map 存储第一个节点到当前节点的全部和sum
    public ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode cur = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();


        while (cur != null){
            sum = sum + cur.val;

            if (sum == 0){
                //直接删除
                head = cur.next;
                //移动cur 指针，继续后边的寻找
                cur = head;
            }else{

                if (map.containsKey(sum)){
                    //关键点：如果map 中出现两个相同的前序和，
                    //说明这两个节点之间的 sum 一定为 0
                    map.get(sum).next = cur.next;
                    cur = head;
                    map.clear();
                    sum = 0;
                }else{

                    //如果map 中不存在，就继续存储前序和
                    map.put(sum, cur);
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
