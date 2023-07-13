import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedList {
    @Test
    public void testAddNode() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.addNode(0, 0, list.head));
        assertEquals(1, list.length);

        assertTrue(list.addNode(1, 1, list.head));
        assertEquals(2, list.length);

        assertTrue(list.addNode(1, 2, list.head));
        assertEquals(3, list.length);

        assertFalse(list.addNode(4, 4, list.head));
        assertEquals(3, list.length);

    }

    @Test
    public void testDeleteNode() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addNode(0, 0, list.head);
        list.addNode(1, 1, list.head);
        list.addNode(2, 2, list.head);

        assertFalse(list.deleteNode(3, list.head));
        assertEquals(3, list.length);

        assertTrue(list.deleteNode(1, list.head));
        assertEquals(2, list.length);

        assertTrue(list.deleteNode(2, list.head));
        assertEquals(1, list.length);

        assertTrue(list.deleteNode(0, list.head));
        assertEquals(0, list.length);
    }
}