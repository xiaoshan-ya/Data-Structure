/**
 * 括号匹配
 */
public class ParenthesesMatching {
    public boolean isParenthesesMatching (String s) {
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
                continue;
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (stack.getTop().equals(")")) {
                    return false;
                }
                else if (stack.getTop().equals("(")) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
