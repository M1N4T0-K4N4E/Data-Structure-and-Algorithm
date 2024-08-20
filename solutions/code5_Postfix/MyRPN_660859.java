package solutions.code5_Postfix;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_660859 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        MyStackA_660859 stack = new MyStackA_660859();
        StringTokenizer st = new StringTokenizer(rpn);
        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if(isNumeric(t)) stack.push(Double.parseDouble(t));
            else {
                if(t.equals("-")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                } else if (t.equals("+")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                } else if (t.equals("*")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);
                } else if (t.equals("/")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}
