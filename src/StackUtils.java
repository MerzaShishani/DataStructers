import java.util.Stack;

public class StackUtils {

    public static String reverse(String input){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()){
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static Boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)){
                stack.push(ch);
            }
            if(isRightBracket(ch)){
                if (stack.empty()) return false;
                char top=stack.pop();
                if (bracketsMatch(top,ch))
                    return false;
            }
        }
        return stack.empty();
    }

    private static Boolean isLeftBracket(char ch){
        return ch == '(' || ch == '<' || ch == '[' || ch == '{';
    }
    private static Boolean isRightBracket(char ch){
        return ch == ')' || ch == '>' || ch == ']' || ch == '}';
    }

    private static Boolean bracketsMatch(char left, char right){
         return (right == ')' && left !='(') ||
                (right == '>' && left !='<') ||
                (right == '}' && left !='{') ||
                (right == ']' && left !='[');
    }
}
