public class maxSum{
    public static int getMaxSum(int[] input){
        int sum=0,max=Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            if(sum<0)
                sum=input[i];
            else
                sum=sum+input[i];
            if(sum>max){
                max=sum;
            }    
        }
        return max;
    }
    public static void main(String[] args) {
        int[] input={-1,4,-3,4,-1,2,1,28,-5,4};
        System.out.println(getMaxSum(input));
    }
}