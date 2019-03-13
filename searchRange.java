class Range{
    public int low,high;
    public Range(){
        low=-1;
        high=-1;
    }
    public Range(int low,int high){
        this.low=low;
        this.high=high;
    }
    public String toString(){
        return "["+this.low+","+this.high+"]";
    }
}
public class searchRange{
    public static int[] rangeHelper(int [] numbers, int low, int high, int target,int[] range){
        // System.out.println(" low "+low+" high "+high);
        if(low>high){
            return range;
        }
        int mid=(low+high)/2;
        if(target < numbers[mid]){
            return rangeHelper(numbers,low,mid-1,target,range);
        }else if(target > numbers[mid]){
            return rangeHelper(numbers,mid+1,high,target,range);
        }else{
            // System.out.println("Range before "+range);
            if(range[0] == -1 || range[0] > mid){
                range[0]=mid;
            }
            if(range[1] == -1 || range[1] < mid){
                range[1]=mid;
            }
            // System.out.println("Range after "+range);
            rangeHelper(numbers, low, mid-1, target, range);
            rangeHelper(numbers,mid+1,high,target,range);
        }
        return range;
    }
    public static int[] findRange(int[] numbers, int target){
        //Range range= new Range();
        int[] range={-1,-1};
        return rangeHelper(numbers,0,numbers.length-1,target,range);
    }
    public static void main(String[] args) {
        int numbers[]={0,0,0,1,2,3};
        int[] s= findRange(numbers,0);
        System.out.println(s[0]+" "+s[1]);
    }
}