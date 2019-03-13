import java.util.HashMap;
import java.util.Hashtable;

public class fourSum{
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
       int count=0;
       HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
       for(int i=0;i<C.length;i++){
           for(int j=0;j<D.length;j++){
               int sum=C[i]+D[j];
               map.put(sum,map.getOrDefault(sum, 0)+1);
           }
       }
       for(int i=0;i<A.length;i++){
           for(int j=0;j<B.length;j++){
               int sum=(A[i]+B[j])*-1;
               count=count+map.getOrDefault(sum, 0);
           }
       }
       return count; 
    }
    public static void main(String[] args) {
        int A[]={1,2};
        int B[]={-2,-1};
        int C[]={-1,2};
        int D[]={0,2};
        System.out.println(fourSumCount(A,B,C,D));
    }
}