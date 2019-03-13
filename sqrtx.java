public class sqrtx{
    public static int sqrt(int x){
        int min=1,max=x,mid;
        while(min<max){
            mid=(min+max)/2;
            int temp=mid*mid;
            if(temp == x)
                return mid;
            if(temp>x){
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(186));
    }
}