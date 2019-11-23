//复杂链表的复制
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

package jianzhioffer;

public class code23 {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }

        RandomListNode cur = pHead;

        //单纯复制链表节点，以及next关系
        while (pHead != null){
            int curVal = pHead.label;
            RandomListNode tmp = new RandomListNode(curVal);
            tmp = cur.next;
            cur.next = tmp.next;
            cur = cur.next.next;
        }

        //复制节点的random 关系
        cur = pHead;
        while (pHead != null){
            if (pHead.random == null){
                pHead.next.random = null;
            }else{
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }

        //拆分
        cur = pHead;
        RandomListNode res = pHead.next;

        while (cur != null){
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            if (clone.next == null){
                clone.next = null;
            }else {
                clone.next = clone.next.next;
            }
            cur = cur.next;
        }

        return res;
    }
}
