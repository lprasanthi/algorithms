import java.util.Stack;

class Node{
    public char data;
    public Node left;
    public Node right;
    public Node(char data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Tree{
    public Node root;
    public Tree(){
        this.root=null;
    }
    public Tree(Node root){
        this.root=root;
    }
}

public class InfixToPostfix{
    public static Node getExpressionTree(String exp){
        char[] expArray= exp.toCharArray();
        Stack<Node> stack= new Stack<Node>();
        Node root;
        for(int i=0;i<expArray.length;i++){
            root=new Node(expArray[i]);
            if(isOperator(expArray[i])){
                Node right=stack.pop();
                Node left=stack.pop();
                root.left=left;
                root.right=right;
                
            }
            stack.push(root);
        }
        return stack.pop();
    }
    public static int getPrecedence(char a){
        switch(a){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public static Boolean isOperator(char a){
        return (a=='+'|| a=='-' || a=='*' || a=='/');
    }
    public static String getPostfix(String exp){
        String postfixExp="";
        char[] infixExp= exp.toCharArray();
        Stack<Character> stack= new Stack<Character>();
        for(int i=0;i<infixExp.length;i++){
            char n= infixExp[i];
            if(!isOperator(n)){
                postfixExp+=n;
            }else{
                while(!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(n)){
                    postfixExp+=stack.pop();
                }
                stack.push(n);
            }    
        }
        while(!stack.isEmpty()){
            postfixExp+=stack.pop();
        }
        return postfixExp;
    }
    public static void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static int eval(int a, int b, char op){
        int c=0;
        switch(op){
            case '+':
                c= a+b;
                break;
            case '-':
                c= a-b;
                break;
            case '*':
                c= a*b;
                break;
            case '/':
                c= a/b;
                break;
        }
        return c;
    }
    public static int evaluate(Node root){
        if(!isOperator(root.data))
            return Integer.parseInt(String.valueOf(root.data));
        int a=evaluate(root.left);
        int b=evaluate(root.right);
        return eval(a,b,root.data);
    }
    public static int evaluateInfix(String infixexp){
        char[] input=infixexp.toCharArray();
        Stack<Integer> operand= new Stack<Integer>();
        Stack<Character> operator= new Stack<Character>();
        for(int i=0;i<input.length;i++){
            if(!isOperator(input[i])){
                operand.push(Integer.parseInt(String.valueOf(input[i])));
            }else{
                if(!operator.isEmpty() && (operator.peek()) >= getPrecedence(input[i])){
                    int operand1=operand.pop();
                    int operand2=operand.pop();
                    int result=eval(operand2,operand1,operator.pop());
                    operand.push(result);
                }
                operator.push(input[i]);
            }
        }
        while(!operator.isEmpty()){
            int operand1=operand.pop();
            int operand2=operand.pop();
            int result=eval(operand2,operand1,operator.pop());
            operand.push(result);
        }
        return operand.pop();

    }
    public static void main(String[] args) {
        String infixExpr="2+2+8-1*5*2";
        int res= evaluateInfix(infixExpr);
        System.out.println(res);
        String postfixExpr=getPostfix(infixExpr);
        System.out.println(postfixExpr);
        Node tree=getExpressionTree(postfixExpr);
        int result=evaluate(tree);
        System.out.println(result);
    }
}