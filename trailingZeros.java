public class trailingZeros{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getTrailingZeros(20));   
    }
}

class Solution{
    public int getTrailingZeros(int n){
        int count =0;
        while(n/5 !=0){
            count = count+n/5;
            n=n/5;
        }
        return count;
    }
}