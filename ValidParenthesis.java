import java.util.Stack;

public class ValidParenthesis{
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char brace=s.charAt(i);
            switch(brace){
                case '(': 
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(!stack.isEmpty() && stack.peek() == brace){
                        stack.pop();
                        break;
                    }
                return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValid(""));
    }
}