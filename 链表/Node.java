/**
 * 节点类
 */
public class Node {
    int data;
    Node next;

    // 构造函数
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = 0;
        this.next = null;
    }
}
