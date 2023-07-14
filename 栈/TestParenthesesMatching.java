import org.junit.Test;
import static org.junit.Assert.*;

public class TestParenthesesMatching {

    @Test
    public void testEmptyString() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertTrue(pm.isParenthesesMatching(""));
    }

    @Test
    public void testSingleOpenParenthesis() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertFalse(pm.isParenthesesMatching("("));
    }

    @Test
    public void testSingleCloseParenthesis() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertFalse(pm.isParenthesesMatching(")"));
    }

    @Test
    public void testOnePairParentheses() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertTrue(pm.isParenthesesMatching("()"));
    }

    @Test
    public void testNestedParentheses() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertTrue(pm.isParenthesesMatching("(())"));
    }

    @Test
    public void testMismatchedParentheses() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertFalse(pm.isParenthesesMatching("(()"));
    }

    @Test
    public void testMultiplePairsParentheses() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertTrue(pm.isParenthesesMatching("()()"));
    }

    @Test
    public void testMixedParentheses() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertFalse(pm.isParenthesesMatching("((())())()("));
    }

    @Test
    public void testNonParenthesesCharacters() {
        ParenthesesMatching pm = new ParenthesesMatching();
        assertTrue(pm.isParenthesesMatching("()a[b]c{d}e"));
    }
}