class Point{
    int row,col;
    public Point(int row,int col){
        this.row=row;
        this.col=col;
    }
    public Point(){
        this.row=-1;
        this.col=-1;
    }

}
public class sortedmatrixSearch{
    public static Point searchMatrixHelper(int[][] a,int n,int row,int col){
        Point p=null;
        if(a[row][col] == n){
            p= new Point(row,col);
            return p;
        }
        //if(n<a[row][col])
        return p;
    }
    public static Point searchMatrix(int[][] a,int n){
        return searchMatrixHelper(a, n,(0+a.length)/2,(0+a.length)/2);
    }
    public static void main(String[] args) {
        int a[][]={{15,20,40,85},
        {20,35,80,93},
        {30,55,95,105},
        {40,80,100,120}};
        Point p= searchMatrix(a, 85);
        if(p){
            System.out.println(p.row+","+p.col);
        }else{
            System.out.println("Not found");
        }
    }
}