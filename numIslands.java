public class numIslands{
    private static void getNumIslandsHelper(char[][] grid,int rows,int cols,int i,int j) {
        if(i<0 || i>=rows || j<0 || j>=cols)
            return;
        if(grid[i][j] != '1')
            return;
        grid[i][j]='0';
        getNumIslandsHelper(grid, rows, cols, i+1, j);
        getNumIslandsHelper(grid, rows, cols, i, j+1);
        getNumIslandsHelper(grid, rows, cols, i-1, j);
        getNumIslandsHelper(grid, rows, cols, i, j-1);
    }
    public static int getNumIslands(char[][] grid) {
        int rows=grid.length;
        if(rows == 0){
            return 0;
        }
        int cols=grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    getNumIslandsHelper(grid,rows,cols,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char grid[][]={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        //char grid[][]={{'1'},{'1'}};
        int count=getNumIslands(grid);
        System.out.println(count);
    }
}