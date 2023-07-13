import org.junit.Test;
import static org.junit.Assert.*;
public class TestStack {
    @Test
    public void testPush () {
        Stack stack = new Stack(100);
        assertTrue(stack.push("1"));
        assertEquals(1, stack.length());

        assertTrue(stack.push("2"));
        assertEquals(2, stack.length());

        assertTrue(stack.push("3"));
        assertEquals(3, stack.length());

        assertTrue(stack.push("4"));
        assertTrue(stack.push("5"));
        assertEquals(5, stack.length());
    }

    @Test
    public void testPop () {
        Stack stack = new Stack(100);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        assertEquals("5", stack.pop());
        assertEquals("4", stack.pop());
    }
}