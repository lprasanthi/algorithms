

public class surroundingRegions{
    private static boolean isSurrounding(char[][] board,int row, int col){
        return (board[row-1][col] == 'X' || board[row+1][col] == 'X' || board[row][col-1] == 'X'
        || board[row][col+1] == 'X');
    }
    private static void markSurrounding(char[][] board,int row,int col,char frommark, char tomark){
        // System.out.println("entered row"+row+" col "+col+"board.length"+board.length+"board[0"+board[0].length);
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            // System.out.println("entered failed");
            //return;
        }else{
            if(board[row][col] == frommark){
                System.out.println("row "+row+" col "+col);
                board[row][col] = tomark;
                markSurrounding(board, row+1, col, frommark, tomark);
                markSurrounding(board, row-1, col, frommark, tomark);
                markSurrounding(board, row, col+1, frommark, tomark);
                markSurrounding(board, row, col-1, frommark, tomark);
                //System.out.println("row4 "+row+" col4 "+col);
            }
        }
    }
    
    public static void solve(char[][] board) {
        int m=board.length;
        if(m <= 2){
            return;
        }
        int n=board[0].length;
        if(n <= 2){
            return;
        }
        for(int i=0;i<n;i++){
            if(board[0][i]== '0'){
                // board[0][i]='1';
                markSurrounding(board,0,i,'0','1');
            }
            if(board[m-1][i] == '0'){
                // board[m-1][i]='1';
                markSurrounding(board,m-1,i,'0','1');
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]== '0'){
                // board[i][0]='1';
                markSurrounding(board,i,0,'0','1');
            }
            if(board[i][n-1] == '0'){
                // board[i][n-1]='1';
                markSurrounding(board,i,n-1,'0','1');
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '0'){
                    if(isSurrounding(board,i,j)){
                        board[i][j]='X';
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '1'){
                        board[i][j]='0';
                }
            }
        }
    }
    public static void main(String[] args) {
        char board[][]={{'0','X','X','0','X'},{'X','0','0','X','0'},
        {'X','0','X','0','X'},{'0','X','0','0','0'},{'X','X','0','X','0'}};
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(board[i][j]+" , ");
            }
            System.out.println();
        }
        solve(board);
        System.out.println("AFTER");
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(board[i][j]+" , ");
            }
            System.out.println();
        }
    }
}