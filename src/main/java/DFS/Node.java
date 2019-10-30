package DFS;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}

    public Node(int val, Node left, Node right, Node next){
        this.left = left;
        this.right = right;
        this.next = next;
        this.val = val;
    }
}
