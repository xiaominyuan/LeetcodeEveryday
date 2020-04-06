//460. LFU缓存
//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
//
//get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
//put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
//「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
//
// 
//
//进阶：
//你是否可以在 O(1) 时间复杂度内执行两项操作？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lfu-cache
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import java.util.HashMap;
import java.util.Map;

//先考虑访问次数，在访问次数相同的情况下，再考虑缓存的时间。

public class LFUCache {
    Map<Integer, Node> cache; //key对应 node
    Map<Integer, DList> freqMap; //每个key的频率对应的链表， 链表上存储这大量相同频率的node
    int size;
    int capacity;
    int min;

    public LFUCache(int capacity){
        this.cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        return node.value;
    }

    public void put(int key, int value){
        if (capacity == 0){
            return;
        }

        Node node = cache.get(key);
        if (node != null){
            node.value = value;
            increaseFreq(node);
        }else{
            if (size == capacity){
                DList minDList = freqMap.get(min);
                //先考虑访问次数，在访问次数相同的情况下，再考虑缓存的时间。
                cache.remove(minDList.tail.pre.key);
                minDList.removeNode(minDList.tail.pre);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DList dList = freqMap.get(1);
            if (dList == null){
                dList = new DList();
                freqMap.put(1, dList);
            }

            dList.addNode(newNode);
            size++;
            min = 1;
        }
    }

    public void increaseFreq(Node node){
        int freq = node.freq;
        DList dList = freqMap.get(freq);
        dList.removeNode(node);
        if (freq == min && dList.head.next == dList.tail){
            min = freq + 1;
        }

        node.freq++;
        dList = freqMap.get(freq+1);
        if (dList == null){
            dList = new DList();
            freqMap.put(freq+1, dList);
        }
        dList.addNode(node);
    }


}

class Node{
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node next;

    public Node(){

    }

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DList{
    Node head;
    Node tail;
    public DList(){
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //加入链表头部
    public void addNode(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
}