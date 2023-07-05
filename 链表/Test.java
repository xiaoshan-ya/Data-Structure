public class Test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        boolean x0 = list.addNodeAfter(0, 0, list.head);
        boolean x1 = list.addNodeAfter(1, 1, list.head);
        boolean x2 = list.addNodeAfter(2, 2, list.head);
        boolean x3 = list.addNodeAfter(3, 3, list.head);
        boolean x4 = list.addNodeBefore(4, 4, list.head);
        boolean delete = list.deleteNode(4, list.head);

        int length = list.length(list.head);
        System.out.println(length);
    }
}
