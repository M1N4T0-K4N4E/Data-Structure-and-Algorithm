package solutions.code5_Postfix;

import java.util.StringTokenizer;

public class MyShuntingYard_660859 {
    private static int order(String c) {
    return switch (c) {
        case "+", "-" -> 1;
        case "*", "/" -> 2;
        default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueExtendsLinkedList<String> queue = new MyQueueExtendsLinkedList<>();
        MyStackL stack = new MyStackL();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
    while (st.hasMoreTokens()) {
        String t = st.nextToken().trim();
        if (MyRPN_660859.isNumeric(t))
            queue.enqueue(t);
        else if (t.equals("(")) {
            stack.push(t);
        } else if (t.equals(")")) {
            while (!stack.peek().equals("(")){
                queue.enqueue(stack.pop());
            }
            stack.pop(); //discard "("
        } else {
            if(!stack.isEmpty()) {
                while (!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            } else {
                stack.push(t);
            }
            // stack.pop();
        }
        System.out.println("current q = " + queue.dumpToString());
    }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    resultPostfixString = queue.dumpToString();
    System.out.println(resultPostfixString);
    return resultPostfixString; //"happy coding";
    }
}