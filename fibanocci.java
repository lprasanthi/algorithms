public class fibanocci{
    public static void printFibanocci(int num){
        int initial=0,prev=1;
        int sum=0;
        for(int i=0;sum<num;i++){
            sum=initial+prev;
            System.out.println(sum);
            initial=prev;
            prev=sum;
        }
    }
    public static void main(String[] args) {
        printFibanocci(1000000);
    }
}