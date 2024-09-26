public class Solution {
    private int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private List<String> convert(String s) {
        List<String> rpn = new ArrayList<>();
        Stack<Character> op = new Stack<>();

        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == ' ') {
                ++i;
            } else if (Character.isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    ++i;
                }
                rpn.add(sb.toString());
            } else if (s.charAt(i) == '(') {
                op.push(s.charAt(i));
                ++i;
            } else if (s.charAt(i) == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    rpn.add(Character.toString(op.peek()));
                    op.pop();
                }
                op.pop();
                ++i;
            } else {
                while (!op.isEmpty() && getPriority(op.peek()) >= getPriority(s.charAt(i))) {
                    rpn.add(Character.toString(op.peek()));
                    op.pop();
                }
                op.push(s.charAt(i));
                ++i;
            }
        }
        while (!op.isEmpty()) {
            rpn.add(Character.toString(op.peek()));
            op.pop();
        }
        return rpn;
    }

    private int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int rhs = stack.pop(), lhs = stack.pop();

                if ("+".equals(s))
                    stack.push(lhs + rhs);
                else if ("-".equals(s))
                    stack.push(lhs - rhs);
                else if ("*".equals(s))
                    stack.push(lhs * rhs);
                else if ("/".equals(s))
                    stack.push(lhs / rhs);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    public int calculate(String s) {
        List<String> rpn = convert(s);
        return evalRPN(rpn);
    }
}