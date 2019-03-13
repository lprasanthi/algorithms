import java.util.Arrays;

public class SumKNegotiations{
    public static int sum(int[] A){
        int sum=0;
        for(int i=0; i<A.length;i++){
            sum=sum+A[i];
        }
        return sum;
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        int sum=0;
        Arrays.sort(A);
        int negatives=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>= 0){
                break;
            }
            negatives++;
        }
        System.out.println(negatives);
        if(negatives == 0){
            if(K%2 == 1){
                A[0]=A[0]*-1;
            }
            return sum(A);
        }
        for(int i=0;i<negatives && K> 0;i++){
            A[i]=A[i]*-1;
            K--;
        }
        if(K!=0) {
            if(K%2 == 0){
                return sum(A);
            }
            Arrays.sort(A);
            A[0]=A[0]*-1;
        }
        return sum(A);
    }
    public static void main(String[] args) {
        int[] A={2,-3,-1,5,-4};
        int sum= largestSumAfterKNegations(A,2);
        //System.out.println(10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1);
    }
}