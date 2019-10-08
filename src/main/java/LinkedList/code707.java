//707. 设计链表
//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
//在链表类中实现这些功能：
//
//get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
// 
//
//示例：
//
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/design-linked-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package LinkedList;

public class code707 {
    private int size;
    private ListNode first;

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public code707(){}

    public int get(int index){
        if (index < = || index > size -1){
            return -1;
        }

        ListNode node = first;

        for (int i = 0; i< index; i++){
            node = node.next;
        }

        return node.val;
    }

    public void addAtIndex(int index, int val){
        if (index <= 0){
            first = new ListNode(val, first);
        }else {
            ListNode node = first;
            for (int i = 0; i< index - 1; i++){
                node = node.next;
                if (node == null){
                    break;
                }
            }

            ListNode pre = node;
            if (pre == null){
                return;
            }

            pre.next = new ListNode(val, pre.next);
        }
        size++;
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index > size - 1){
            return;
        }

        if (index == 0){
            first = first.next;
        }else {
            ListNode node = first;
            for (int i = 0; i< index - 1; i++){
                node = node.next;
            }
            ListNode pre = node;
            if (pre == null){
                return;
            }
            pre.next = pre.next.next;
        }
        size--;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
}
