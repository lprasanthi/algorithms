public class ClumsyFactorial{
    public static int eval(int a, int b, char operand){
        switch(operand){
            case '*': return a*b;
            case '/': return a/b;
            case '+': return a+b;
            case '-': return a-b;
        }
        return 0;
    }
    public static int clumsy(int N) {
        int sum=N;
        char[] op={'*','/','+','-'};
        int[] buffer=new int[N];
        int j=0;
        for(int i=1;i<=N;i++){
            if(op[(i-1)%4] != '-'){
                sum= eval(sum,N-i, op[(i-1)%4]);
            }
            else{
                buffer[j]=sum;
                sum=N-i;
                j++;
            }
        }
        for(int i=0;i<buffer.length;i++)
            System.out.println(buffer[i]);
        return sum;
    }
    public static void main(String[] args) {
        int n=clumsy(10);
        System.out.println(n);
    }
}