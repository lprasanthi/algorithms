public class findPeak{
    private static int peakHelper(int[] a,int low,int high){
        int mid=(low+high)/2;
        if((a[mid]>a[mid-1] || mid== 0) && (a[mid]>a[mid+1] || mid==a.length-1)){
            return mid;
        }else if(a[mid-1]>a[mid]){
            return peakHelper(a, low, mid-1);
        }else{
            return peakHelper(a, mid+1, high);
        }
    }
    public static int findPeakElement(int[] nums) {
        return peakHelper(nums,0,nums.length-1);
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        int peak=findPeakElement(nums);
        System.out.println(peak);
    }
}