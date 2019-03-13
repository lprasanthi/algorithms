public class KthLargestArray{
    private static int quickSort(int[] a,int low,int high,int k){
        System.out.println("k "+k+" low "+low+" high "+high);
        for(int p=0;p<a.length;p++)
            System.out.print(" , "+a[p]);
        System.out.println();
        int i=low,j=high-1,pivot=high;
        while(i<=j){
            while(i<high && a[i]<a[pivot])
                i++;
            while(j>=low && a[j]>=a[pivot])
                j--;
            System.out.println("i "+i+" j "+j);
            if(i<=j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i];
        a[i]=a[pivot];
        a[pivot]=temp;
        if(i == k){
            return a[i];
        }
        if(i<k){
            return quickSort(a,i+1,high,k);
        }
        return quickSort(a,low,i-1,k);
    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }
    public static void main(String[] args) {
       int input[]={2,1};
       int k=1;
       System.out.println(findKthLargest(input,k)); 
    }
}