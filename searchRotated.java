public class searchRotated{
    private static int searchHelper(int[] a,int n,int low,int high){
        if(low > high)
            return -1;
        else{
            int mid=(low+high)/2;
            if(a[mid] == n)
                return mid;
            else if(a[low] < a[mid]){
                if(n < a[mid] && n >= a[low])
                    return searchHelper(a, n, low, mid-1);
                else
                    return searchHelper(a, n, mid+1, high);
            }else if(a[low] > a[mid]){
                if(n > a[mid] && n <= a[high])
                    return searchHelper(a, n, mid+1, high);
                else
                    return searchHelper(a, n, low, mid-1);
            }else if(a[mid] == a[low]){
                if(a[mid] != a[high]){
                    return searchHelper(a, n, mid+1, high);
                }else {
                    int result=searchHelper(a, n, low, mid-1);
                    if(result == -1){
                        return searchHelper(a, n, mid+1, high);
                    }else{
                        return result;
                    }
                }
            }
        }
        return -1;
    }
    public static int search(int[] a, int n){
        return searchHelper(a,n,0,a.length-1);
    }
    public static void main(String[] args) {
        int a[]={4,2,2,2,3,4,4};
        int index=search(a,2);
        System.out.println(index);
    }
}