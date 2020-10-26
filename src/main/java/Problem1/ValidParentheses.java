package Problem1;

import java.util.LinkedList;

public class ValidParentheses {
    private static LinkedListStack stack = new LinkedListStack<String>();
    // Do not change signature (function name, parameters, return type)
    public static boolean isValid(String str) {
        if(str == null){
            return true;
        }

        if(str.length() == 0){
            return true;
        }

        if(str.length() % 2 != 0){
            return false;
        }

        for(int i = 0;i <= str.length()-1; i++){
            char c = str.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }

            if(stack.peek() == null){
                return false;
            }

            char isOpen;
            switch(c){
                case ')':
                    isOpen = (char) stack.pop();
                    if(isOpen != '(')
                        return false;
                    break;
                case '}':
                    isOpen = (char) stack.pop();
                    if(isOpen != '{')
                        return false;
                    break;
                case ']':
                    isOpen = (char) stack.pop();
                    if(isOpen != '[')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
