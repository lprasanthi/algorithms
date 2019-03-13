public class gameoflife{
    private static int getNextLives(int[][] board,int i,int j,int m,int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(board[i][j] == 1 || board[i][j] == 3)
            return 1;
        return 0;
    }
    private static int getLives(int[][] board,int i,int j,int m,int n){
        int lives=0;
        lives=getNextLives(board, i+1, j+1, m, n)+
        getNextLives(board, i+1, j-1, m, n)+
        getNextLives(board, i-1, j+1, m, n)+
        getNextLives(board, i-1, j-1, m, n)+
        getNextLives(board, i+1, j, m, n)+
        getNextLives(board, i-1, j, m, n)+
        getNextLives(board, i, j+1, m, n)+
        getNextLives(board, i, j-1, m, n);
        return lives;
    }
    public static void gameOfLife(int[][] board) {
       int m=board.length;
       int n=board[0].length;
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               int lives=getLives(board,i,j,m,n);
               if(board[i][j] == 0){
                   if(lives == 3)
                        board[i][j]=2;
               }else if(board[i][j] == 1){
                   if(lives < 2 || lives > 3)
                       board[i][j]=3;
               }
           }
       }
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(board[i][j] == 2)
                   board[i][j]=1;
               else if(board[i][j] == 3)
                    board[i][j]=0;
           }
       } 
    }
    public static void main(String[] args) {
        int board[][]={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+", ");
            }
            System.out.println();
        }
    }
}