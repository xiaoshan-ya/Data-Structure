import static java.lang.Character.isDigit;

/**
 * 表达式转换
 */
public class Expression {
    /**
     * 中缀表达式转为后缀表达式
     * @param infix 中缀表达式
     * @return 后缀表达式
     */
    public String toPostfix (String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack operatorStack = new Stack(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            if (isDigit(infix.charAt(i))) { //如果是数字则入栈
                postfix.append(infix.charAt(i));
            }
            else if (isOperator(infix.charAt(i))) {
                if (operatorStack.isEmpty()) { //如果操作符栈为空则入栈
                    operatorStack.push(String.valueOf(infix.charAt(i)));
                }
                else { //依次弹出栈中高于或等于当前运算符的元素，否则就入栈
                    if (getOperatorPriority(operatorStack.getTop())
                            >= getOperatorPriority(String.valueOf(infix.charAt(i)))) {
                        postfix.append(operatorStack.pop());
                    }
                    else if (infix.charAt(i) == '(') {
                        operatorStack.push(String.valueOf(infix.charAt(i)));
                    }
                    else if (infix.charAt(i) == ')') {
                        while (!operatorStack.getTop().equals("(")) {
                            postfix.append(operatorStack.pop());
                        }
                        operatorStack.pop();
                    }
                    else {
                        operatorStack.push(String.valueOf(infix.charAt(i)));
                    }
                }
            }
            return null;
        }
        return postfix.toString();
    }

    /**
     * 后缀表达式计算
     * @param postfix 后缀表达式
     * @return 计算结果
     */
    public String calculationPostfix (String postfix) {
        Stack number = new Stack(postfix.length());
        for(int i = 0; i < postfix.length(); i++ ) {
            if (isDigit(postfix.charAt(i))) {
                number.push(String.valueOf(postfix.charAt(i)));
            }
            else {
                int first, second;
                switch (postfix.charAt(i)) {
                    case '+':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first + second));
                        break;
                    case '-':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first - second));
                        break;
                    case '*':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first * second));
                        break;
                    case '/':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first / second));
                        break;
                    case '&':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first & second));
                        break;
                    case '^':
                        second = Integer.parseInt(number.pop());
                        first = Integer.parseInt(number.pop());
                        number.push(String.valueOf(first ^ second));
                        break;
                }
            }
        }

        return number.pop();
    }

    /**
     * 后缀表达式转为中缀表达式
     * 实现：类似后缀表达式计算，只是把运算过程改为字符串操作
     * @param postfix 后缀表达式
     * @return 中缀表达式
     */
    public String toInfix (String postfix) {
        StringBuilder infix = new StringBuilder();
        Stack operatorStack = new Stack(postfix.length());

        for(int i = 0; i < postfix.length(); i++) {

        }

        return postfix.toString();
    }

    /**
     * 判断是否是操作符
     * @param c 操作符
     * @return 是操作符返回true
     */
    private boolean isOperator (char c) {
        return c == '+' || c == '-' || c == '*'
                || c == '/' || c == '%' || c == '^'
                || c == '&' || c == '(' || c == ')';
    }

    /**
     * 得到操作符优先级
     * @param op 操作符
     * @return 返回优先级
     */
    private int getOperatorPriority(String op) {
        switch (op) {
            case "(", ")": return 0;
            case "+", "-": return 1;
            case "*", "/", "%": return 2;
            case "&": return 5;
            case "^": return 6;
        }
        return -1;
    }
}
