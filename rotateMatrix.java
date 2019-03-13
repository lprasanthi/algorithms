public class rotateMatrix{
    public static int[][] rotateMatrix90(int[][] a){
        int n=a.length-1;
        for(int i=0;i<a.length/2;i++){
            for(int j=i;j<n-i;j++){
                //System.out.println(j);
                int temp=a[i][j];
                a[i][j]=a[n-j][i];
                a[n-j][i]=a[n-i][n-j];
                a[n-i][n-j]=a[j][n-i];
                a[j][n-i]=temp;
                
            }
        }
        return a;
    }
    public static void print(int[][] input){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length;j++){
                System.out.print(input[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] input={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("before rotation");
        print(input);
        int[][] rotatedInput=rotateMatrix90(input);
        System.out.println("after rotation");
        print(rotatedInput);
    }
}