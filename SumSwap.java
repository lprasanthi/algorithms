public class SumSwap{
    public static int sumArray(int[] a){
        int sum=0,i;
        for(i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        return sum;
    }
    public static int[] swapSum(int[] a,int[] b){
        int value[]={0,0};
        int i=0,j=0;
        int sumA=sumArray(a);
        int sumB=sumArray(b);
        int target=(sumA-sumB)/2;
        while(i<a.length && j<b.length){
            if(a[i]-b[j] == target){
                value[0]=a[i];
                value[1]=b[j];
                return value;
            }else if(a[i]-b[j] > target){
                j++;
            }else{
                i++;
            }     
        }
        return value;
    }
    public static void main(String[] args) {
        int a[]={4,1,2,1,1,2},b[]={3,6,3,3};
        int[] value=swapSum(a,b);
        System.out.println(value[0]+","+value[1]);
    }
}