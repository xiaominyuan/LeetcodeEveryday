//146. LRU缓存机制
//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：
// 获取数据 get 和 写入数据 put 。
//
//获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lru-cache
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/

package HashTable;

import java.util.HashMap;

public class LRUCache {
    class Node{
        public int key;
        public int val;
        public Node next;
        public Node prev;
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

    class DList{
        public Node head;
        public Node tail;
        public int size;

        public DList(){
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node x){
            x.prev = head;
            x.next = head.next;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast(){
            if (tail.prev == head){
                return null;
            }

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    public HashMap<Integer, Node> map;
    public DList cache;
    public int size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DList();
        this.size = capacity;
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value){
        Node node = new Node(key, value);

        if (map.containsKey(key)){
            Node tmp = map.get(key);
            cache.remove(tmp);
            cache.addFirst(node);
            map.put(key, node);
        }else{
            if (size == cache.size){
                Node tmp = cache.removeLast();
                map.remove(key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }
}
