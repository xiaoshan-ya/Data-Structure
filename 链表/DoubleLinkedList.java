/**
 * 双链表类
 */
public class DoubleLinkedList {
    DoubleNode head;

    int length = 0;

    public DoubleLinkedList() {this.head = new DoubleNode();}

    public boolean addNode (int i, int data, DoubleNode head) {
        if (i > length) return false;
        if (head.next == null) {
            DoubleNode newNode =new DoubleNode(data);
            newNode.prior = head;
            newNode.next = null;
            length++;
            return true;
        }

        int j = 0;
        DoubleNode p = head;
        while (j < i) {
            j++;
            p = (DoubleNode) p.next;
        }
        DoubleNode newNode =new DoubleNode(data);
        newNode.next = null;
        newNode.prior = p;
        p.next = newNode;
        this.length++;
        return true;
    }

    public boolean deleteNode (int i, DoubleNode head) {
        if (i > length) return false;
        int j = 0;
        DoubleNode p = head;
        while (j < i) {
            j++;
            p = (DoubleNode) p.next;
        }
        if (p.next == null) {
            p.prior.next = null;
        }
        else {
            p.next.prior = p.prior;
            p.prior.next = p.next;
        }
        return true;
    }
}
