public class perfectSquares{
    public static int numSquares(int n) {
        if(n<4)
            return n;
        int[] lookup=new int[n+2];
        for(int i=0;i<4;i++){
            lookup[i]=i;
        }
        for(int i=4;i<=n;i++){
            int min=i;
            for(int j=1;j*j<=i;j++){
               min=Math.min(min, 1+lookup[i-(j*j)]); 
            }
            lookup[i]=min;
        }
        return lookup[n];
    }
    public static void main(String[] args) {
        int n=55;
        System.out.println(numSquares(n));
    }
}