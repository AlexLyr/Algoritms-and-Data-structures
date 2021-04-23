package ru.algoritms.datastructures.stack;

public class ParenthesisCounter {

    public static boolean isParentesisBalanced(String parenthesis) {
        Stack<Character> stack = new Stack<>();
        for (char symbol : parenthesis.toCharArray()) {
            if (symbol == '(') {
                stack.push(symbol);
            } else if (symbol == ')' && stack.size() != 0) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static double calculatePostfixStatment(String statement) {
        Stack<Double> stack = new Stack<>();
        for (String element : statement.split(" ")) {
            try {
                double i = Double.parseDouble(element);
                stack.push(i);
            } catch (Exception e) {
                Double secondElem = stack.pop();
                Double firstElem = stack.pop();
                double result;
                switch (element) {
                    case "+":
                        result = firstElem + secondElem;
                        stack.push(result);
                        break;
                    case "*":
                        result = secondElem * firstElem;
                        stack.push(result);
                        break;
                    case "/":
                        result = firstElem / secondElem;
                        stack.push(result);
                        break;
                    case "-":
                        result = firstElem - secondElem;
                        stack.push(result);
                        break;
                    default:
                        throw new RuntimeException("Statement contains incorrect characters");
                }
            }
        }
        if (stack.size() != 1) {
            throw new RuntimeException("Not valid statement!");
        }
        return stack.pop();
    }
}
