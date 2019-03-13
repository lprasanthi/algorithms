public class eightQueensOptimal{
    public static int size=8;
    private static boolean isValid(int[] a, int row, int col){
        for(int i=0;i<row;i++){
            if(a[i] == col){
                return false;
            }
            if((row-i) == Math.abs(a[i]-col)){
                return false;
            }
        }
        return true;
    }
    private static int[] getQueensBoardHelper(int[] a,int row,int col){
        if(row == size)
            return a;      
        for(int i=col;i<size;i++){
            if(isValid(a,row,i)){
                a[row]=i;
                // System.out.println("found"+a[row]);
                return getQueensBoardHelper(a,row+1,0);
            }
        }
        if(a[row] == -1){
            row=row-1;
            int prevCol=a[row];
            a[row]=-1;
            // System.out.println("backtracking"+prevCol);
            return getQueensBoardHelper(a, row, prevCol+1);
        }
        return a;
    }
    public static int[] getQueensBoard(){
        int a[]=new int[size];
        for(int i=0;i<size;i++)
            a[i]=-1;
        return getQueensBoardHelper(a,0,0);
    }
    public static void main(String[] args) {
        int b[]=getQueensBoard();
        System.out.println("printing board");
        for(int i=0;i<size;i++){
            System.out.println(b[i]);
        }
    }
}