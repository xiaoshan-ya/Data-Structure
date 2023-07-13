import java.util.ArrayList;

/**
 * 栈类
 */
public class Stack {
    /**
     * 栈
     */
    String[] stack;
    int maxLength;

    /**
     * 栈顶指针
     */
    int top;

    public Stack(int maxLength) {
        this.top = -1;
        this.maxLength = maxLength;
        this.stack = new String[maxLength];
    }

    public boolean isEmpty () {
        return stack.length == 0;
    }

    public int length () {
        return top + 1;
    }

    /**
     * 入栈
     */
    public boolean push (String data) {
        if (this.top == this.maxLength - 1) {
            return false;
        }
        this.stack[++top] = data;
        return true;
    }

    public String pop () {
        if (this.stack.length == 0) {
            return null;
        }
        return this.stack[top--];
    }
}
