import org.junit.Test;
import static org.junit.Assert.*;
public class TestExpression {
    private final Expression calculator = new Expression();
    private final Expression expression = new Expression();

    @Test
    public void testCalculationPostfix() {
        // 测试加法
        assertEquals("3", calculator.calculationPostfix("12+"));
        assertEquals("12", calculator.calculationPostfix("345++"));
        // 测试减法
        assertEquals("-1", calculator.calculationPostfix("12-"));
        assertEquals("2", calculator.calculationPostfix("345--"));
        // 测试乘法
        assertEquals("6", calculator.calculationPostfix("23*"));
        assertEquals("20", calculator.calculationPostfix("345**"));
        // 测试除法
        assertEquals("2", calculator.calculationPostfix("46/"));
        assertEquals("4", calculator.calculationPostfix("345//"));
        // 测试位与运算
        assertEquals("0", calculator.calculationPostfix("5&3&"));
        assertEquals("1", calculator.calculationPostfix("5&4&"));
        // 测试位异或运算
        assertEquals("6", calculator.calculationPostfix("53^"));
        assertEquals("4", calculator.calculationPostfix("54^"));
        // 测试数字边界情况
        assertEquals("1000000", calculator.calculationPostfix("1000000"));
        assertEquals("10", calculator.calculationPostfix("10"));
        // 测试除数为0的情况
        try {
            calculator.calculationPostfix("42/");
            fail("Expected ArithmeticException was not thrown");
        } catch(ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testToPostfix() {
        // 测试只有一个数字的情况
        assertEquals("5", expression.toPostfix("5"));
        // 测试只有一个操作符的情况
        assertEquals("12+", expression.toPostfix("1+2"));
        // 测试加减乘除运算
        assertEquals("23+4*", expression.toPostfix("2+3*4"));
        assertEquals("23+4*5-", expression.toPostfix("2+3*4-5"));
        assertEquals("23+45+*", expression.toPostfix("(2+3)*(4+5)"));
        assertEquals("23*45/-", expression.toPostfix("2*3/(4-5)"));
        // 测试括号
        assertEquals("23+45+*", expression.toPostfix("(2+3)*(4+5)"));
        assertEquals("23+45+*", expression.toPostfix("((2+3)*(4+5))"));
        assertEquals("23+45+*", expression.toPostfix("(((2+3))*(4+5))"));
        assertEquals("23+45-*", expression.toPostfix("2-(3-4)*5"));
        assertEquals("234*+5+", expression.toPostfix("2+3*4+5"));
        // 测试数字边界情况
        assertEquals("1000000", expression.toPostfix("1000000"));
        assertEquals("10", expression.toPostfix("10"));
        // 测试表达式错误的情况
        try {
            expression.toPostfix("2+3+");
            fail("Expected IllegalArgumentException was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("Invalid infix expression: 2+3+", e.getMessage());
        }
        try {
            expression.toPostfix("2+(3*4");
            fail("Expected IllegalArgumentException was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("Invalid infix expression: 2+(3*4", e.getMessage());
        }
    }
}
