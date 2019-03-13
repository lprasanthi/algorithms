public class wordSearch{
    private static boolean doesExist(char[][] board,String word,int index,int row,int col,boolean[][] visited){
        System.out.println("row and col "+row+" "+col+" index "+index);
        if(index == word.length())
            return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || visited[row][col])
            return false;
        if(board[row][col] != word.charAt(index))
            return false;
        index=index+1;
        visited[row][col]=true;
        boolean exist= doesExist(board, word, index, row, col+1,visited) || 
            doesExist(board, word, index, row, col-1,visited)||
            doesExist(board, word, index, row+1, col,visited)||
            doesExist(board, word, index, row-1, col,visited);
        visited[row][col]=false;
        return exist;
             
    }
    // private static boolean doesExist(char[][] board,String word){
    //     int index=0;
    //     int row=board.length,col=board[0].length;
    //     for(int i=0;i<row;i++){
    //         for(int j=0;j<col;j++){
    //             if(board[i][j] == word.charAt(index)){

    //             }
    //         }
    //     }
    // }
    public static boolean exist(char[][] board, String word) {
        if(board.length == 0)
            return false;
        boolean visited[][]= new boolean[board.length][board[0].length];
        int row=board.length,col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(doesExist(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char board[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char board1[][]={{'A','A'}};
        System.out.println(exist(board1, "AAA"));
    }
}