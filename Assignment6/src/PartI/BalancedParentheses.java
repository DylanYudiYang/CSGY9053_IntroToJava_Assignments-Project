package PartI;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String inString) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

	public static void main(String[] args) {
	System.out.println(isBalanced("(()()()())"));
	System.out.println(isBalanced("(((())))"));
	System.out.println(isBalanced("((((((())"));
}
	
}


