package com.codecool.simplecalculator;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        while (true) {
            Float a = askForANumber(false);
            if (a == null) {
                break;
            }
            String op = askForAnOperator(true);
            Float b = askForANumber(true);
            float result = calc(op, a, b);
            System.out.println("The result is " + result);
        }
    }

    public static Float isNumber(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static boolean isValidOperator(String operator) {
        String[] operators = {"+", "-", "/", "*"};
        for (String op : operators) {
            if (op.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static Float askForANumber(boolean forceValidInput) {
        while (true) {
            String inp = input("Please provide a number!");
            Float nr = isNumber(inp);
            if (nr != null) {
                return nr;
            } else {
                if (!forceValidInput) {
                    return null;
                }
                System.out.println("This didn't look like a number, try again.");
            }
        }
    }

    public static String askForAnOperator(boolean forceValidInput) {
        while (true) {
            String inp = input("Please provide an operator (one of +, -, *, /)!");
            if (isValidOperator(inp)) {
                return inp;
            } else {
                if (!forceValidInput) {
                    return null;
                }
                System.out.println("Unknown operator.");
            }
        }
    }

    public static Float calc(String op, Float a, Float b) {
        if (!isValidOperator(op)) {
            return null;
        }
        Float res = null;
        if (op.equals("+")) {
            res = a + b;
        } else if (op.equals("-")) {
            res = a - b;
        } else if (op.equals("/")) {
            if (b != 0.0f) {
                res = a / b;
            } else {
                System.out.println("Error: Division by zero");
            }
        } else if (op.equals("*")) {
            res = a * b;
        }

        return res;
    }

    private static String input(String prompt) {
        System.out.print(prompt + " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
