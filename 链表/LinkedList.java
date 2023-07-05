/**
 * 链表类
 */
public class LinkedList {
    Node head;
    int length = 0;

    // 构造函数
    public LinkedList() {
        head = new Node();
    }

    /**
     * 在指定位置后插节点, 注意：传入的链表头节点不需要指针也可以将链表插入
     * @param i 指定链表位置
     * @param data 插入节点的数据
     * @param head 链表头节点
     * @return 成功与否
     */
    public boolean addNodeAfter(int i, int data, Node head) {
        if (i > this.length) return false;
        if (head.next == null) {
            head.next = new Node(data);
            length++;
            return true;
        }
        int j = 0;
        Node p = head;
        while (p.next != null && j < i) {
            j++;
            p = p.next;
        }
        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        this.length++;
        return true;
    }
    /**
     * 在指定位置前插节点
     * @param i 指定链表位置
     * @param data 插入节点的数据
     * @param head 链表头节点
     * @return 成功与否
     */
    public boolean addNodeBefore(int i, int data, Node head) {
        if (i > this.length) return false;
        if (head.next == null) {
            head.next = new Node(data);
            length++;
            return true;
        }
        int j = 0;
        Node p = head;
        while (p.next != null && j < i) {
            j++;
            p = p.next;
        }
        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        this.length++;
        p.data = p.data ^ newNode.data;
        newNode.data = p.data ^ newNode.data;
        p.data = p.data ^ newNode.data;
        return true;
    }

    /**
     * 删除指定位置节点
     * @param i 需要删除的节点位置
     * @param head 链表头节点
     * @return 成功与否
     */
    public boolean deleteNode(int i, Node head) {
        if (i > length) return false;
        int j = 0;
        Node p = head;
        while(j < i) {
            j++;
            p = p.next;
        }
        p.data = p.next.data;
        p.next = p.next.next;
        return true;
    }

    public int length (Node head) {
        int i = 0;
        while(head.next != null) {
            i++;
            head = head.next;
        }
        return i;
    }
}
