package ru.algoritms.datastructures.stack;

public class ParenthesisCounter {

    public static boolean isParentesisBalanced(String parenthesis) {
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
        for (char symbol : parenthesis.toCharArray()) {
            if(symbol == '(') {
                stack.push(symbol);
            } else if(symbol == ')') {
                Character openParenthesis = stack.pop();
                isBalanced = openParenthesis != null;
            }
        }
        return isBalanced && stack.size() == 0;
    }
}
