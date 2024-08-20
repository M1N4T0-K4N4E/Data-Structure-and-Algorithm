package Labs;

import solutions.code5_Postfix.*;

public class Lab5_RPN_Main {
    static void task2(String postfixString) {
        System.out.println();
        System.out.print(postfixString);
        System.out.println(" = " + MyRPN_660859.computeRPN(postfixString));
    }

    static void task1(String postfixString) {
        System.out.println();
        System.out.print(postfixString);
        System.out.println(" = " + MyRPN_660859.computeRPN(postfixString));
    }
    public static void main(String[] args) {
        String postfixString = "3 1 - 4 5 + *";
        task1(postfixString);
        postfixString = "8 5 - 4 2 + 3 / *";
        task2(postfixString);
    }
}