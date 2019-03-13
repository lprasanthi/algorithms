import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class Point{
    int row,col;
    public Point(int row,int col){
        this.row=row;
        this.col=col;
    }
    public String toString(){
        return "("+this.row+","+this.col+")";
    }
}
public class maze{
    // wrong wont work for more than 1 path.
    // private static List<Point> findPathRec(Boolean maze[][],int row,int col,HashSet<Point> failed){
    //     List<Point> list=new ArrayList<Point>();
    //     if(row >= maze.length || col >= maze[0].length){
    //         return list;
    //     }
    //     Point p= new Point(row,col);
    //     if(row == maze.length-1 && col == maze[0].length-1){
    //         list.add(p);
    //         return list;
    //     }
    //     if(failed.contains(p) || !maze[row][col]){
    //         return list;
    //     }
    //     List<Point> rowList=findPathRec(maze, row+1, col,failed);
    //     List<Point> colList=findPathRec(maze, row, col+1,failed);
    //     System.out.println("point "+p+"rows "+rowList+"cols "+colList);
    //     if(rowList.size()>0 || colList.size()>0){
    //         list.add(p);
    //         list.addAll(rowList);
    //         list.addAll(colList);
    //         return list;
    //     }
    //     failed.add(p);
    //     return list;
    // }

    private static boolean pathHelper(Boolean maze[][],int row, int col, List<Point> path, HashSet<Point> failed){
        if(row ==0 && col ==0)
            return true;   
        if(row < 0 || col < 0 || !maze[row][col])
            return false;
        Point p= new Point(row,col);
        if(failed.contains(p))
            return false;
        if(pathHelper(maze, row-1, col, path, failed) || pathHelper(maze, row, col-1, path, failed)){
            path.add(p);
            return true;
        }
        failed.add(p);
        return false;
    }
    public static List<Point> findpath(Boolean maze[][]){
        List<Point> path=new ArrayList<Point>();
        HashSet<Point> failed=new HashSet<Point>();
        pathHelper(maze, 4, 4, path, failed);
        // path=findPathRec(maze,0,0,failed);
        return path;
    }
    public static void main(String[] args) {
        Boolean maze[][]={
            {true,true,true,true,true},
            {false,false,false,true,false},
            {false,false,true,true,true},
            {false,false,false,true,true},
            {false,false,false,true,true}
        };
        List<Point> p= findpath(maze);
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i));
        }
    }
}