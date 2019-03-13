public class peaksValley{
    public static int[] peakValleyPattern(int[] a){
        for(int i=1;i<a.length;i+=2){
            int index=getPeakIndex(a,i-1,i,i+1);
            if(index != i){
                int temp=a[i];
                a[i]=a[index];
                a[index]=temp;
            }
        }
        return a;
    }
    private static int getPeakIndex(int[] a,int low,int med,int high){
        int max=med;
        if(low >=0){
            max=Math.max(a[max], a[low])==a[max]?max:low;
        }
        if(high<a.length){
            max=Math.max(a[max], a[high])==a[max]?max:high;
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]={9,1,0,4,8,7};
        a=peakValleyPattern(a);
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}