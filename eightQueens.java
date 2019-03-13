public class eightQueens{
    public static int size=8;
    public static int[][] initialise(int[][] a){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                a[i][j]=-1;
            }
        }
        return a;
    }
    private static int[][] markColumn(int[][] board,int col,int mark){
        for(int i=0;i<size;i++){
            board[i][col]=board[i][col]+mark;
        }
        return board;
    }
    private static int[][] markRow(int[][] board,int row,int mark){
        for(int i=0;i<size;i++){
            board[row][i]+=mark;
        }
        return board;
    }
    private static int[][] markDiagonal(int[][] board,int row,int col, int mark){
        int i=row+1;int j=col+1;
        while(i>=0 && i<size && j>=0 && j < size){
            board[i][j] += mark;
            i++;j++;
        }
        i=row+1;j=col-1;
        while(i>=0 && i<size && j>=0 && j < size){
            board[i][j] += mark;
            i++;j--;
        }
        i=row-1;j=col+1;
        while(i>=0 && i<size && j>=0 && j < size){
            board[i][j] += mark;
            i--;j++;
        }
        i=row-1;j=col-1;
        while(i>=0 && i<size && j>=0 && j < size){
            board[i][j] += mark;
            i--;j--;
        }
        return board;
    }
    private static int[] getQueensBoardHelper(int[][] board, int[] a,int row, int col){
        int j=col;
        if(row == size)
            return a;      
        for(;j<size;j++){
            if(board[row][j] == -1){
                a[row]=j;
                board=markColumn(board,j,1);
                //board=markRow(board,row,1);
                board=markDiagonal(board,row,j,1);
                return getQueensBoardHelper(board,a,row+1,0);
            }
       }
       if(j == size && row<size && row>0){
            row--;
            j=a[row]; 
            board=markDiagonal(board,row,j,-1);
            board=markColumn(board,j,-1);
            //board=markRow(board,row,-1);
            j++;
            return getQueensBoardHelper(board,a,row,j);
       }
       return a;
    }
    public static int[] getQueensBoard(int[][] board){
        int a[]=new int[size];
        for(int i=0;i<size;i++)
            a[i]=-1;
        return getQueensBoardHelper(board,a,0,0);
    }
    public static void main(String[] args) {
        int a[][]= new int[size][size];
        a=initialise(a);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
        int b[]=getQueensBoard(a);
        System.out.println("printing board");
        for(int i=0;i<size;i++){
            System.out.println(b[i]);
        }
    }
}