package jianzhioffer;

import java.util.HashMap;

public class LRUCache16 {

    class Node{
        public int key;
        public int value;
        public Node next;
        public Node pre;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class Dlist{
        public Node head;
        public Node tail;
        public int size;
        public Dlist(){
            head = new Node(0,0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            this.size = size;
        }

        public void addFirst(Node x){
            x.next = head.next;
            x.pre =head;
            head.next.pre = x;
            head.next = x;
            size++;
        }

        public void remove(Node x){
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        public Node removeLast(){
            if (head.next == tail){
                return null;
            }

            Node last = tail.pre;
            remove(last);
            return last;
        }
    }

    public HashMap<Integer, Node> map;
    public Dlist list;
    public int size;

    public LRUCache16(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.list = new Dlist();
    }

    public int get(int key){
        if (map.containsKey(key)){
            int val = map.get(key).value;
//            Node tmp = new Node(key, val);
            put(key, val);
            return val;
        }else{
            return -1;
        }
    }

    public void put(int key , int value){
        if (map.containsKey(key)){
            Node tmp = new Node(key, value);
            list.remove(tmp);
            list.addFirst(tmp);
            map.put(key, tmp);
        }else{
            Node tmp = new Node(key, value);
            if (list.size == size){
                list.remove(tmp);
            }
            list.addFirst(tmp);
            map.put(key, tmp);
        }
    }
}
