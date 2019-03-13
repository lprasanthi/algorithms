import java.util.Stack;

class MinimumStack{
    int min=Integer.MIN_VALUE;
    Stack<Integer> s;
    public MinimumStack() {
        s= new Stack<Integer>();
    }
    
    public void push(int x) {
        if(s.empty()){
            min=x;
            s.push(0);
        }else{
            s.push(x-min);
            if(x < min)
                min=x;
        }
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        int top=s.pop();
        if(top < 0)
            min=min-top;
    }
    
    public int top() {
        if(s.isEmpty())
            return Integer.MIN_VALUE;
        if(s.peek() >0)
            return s.peek()+min;
        return min;
    }
    
    public int getMin() {
        return min;
    }
}
public class minStack{
    public static void main(String[] args) {
        MinimumStack stack=new MinimumStack();
        stack.push(-2);
        stack.push(0);
        stack.push(8);
        stack.push(-16);
        stack.push(-8);
        stack.push(3);
        stack.push(-1);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}