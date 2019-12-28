//146. LRU缓存机制
//

package ershua;

import java.util.HashMap;

public class LRUCache146 {
    class Node{
        public int key;
        public int val;
        public Node next;
        public Node prev;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    class Dlist{
        public Node head;
        public Node tail;
        public int size;

        Dlist(){
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
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

            Node tmp = tail.prev;
            remove(tmp);
            return tmp;
        }
    }

    public HashMap<Integer, Node> map;
    public Dlist dlist;
    public int size;

    public LRUCache146(int capacity){
        this.map = new HashMap<>();
        this.dlist = new Dlist();
        this.size = capacity;
    }

    public void put(int key, int value){
        Node x = new Node(key, value);
        if (map.containsKey(key)){
            dlist.remove(map.get(key));
            dlist.addFirst(x);
            map.put(key, x);
        }else{
            if (size == dlist.size){
                dlist.removeLast();
            }
            dlist.addFirst(x);
            map.put(key, x);
        }
    }


}
