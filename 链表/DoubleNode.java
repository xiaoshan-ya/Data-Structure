public class DoubleNode extends Node {
    DoubleNode next;
    DoubleNode prior;

    public DoubleNode (int data) {
        super(data);
        this.prior = null;
    }
    public DoubleNode () {
        super();
        this.prior = null;
    }
}
