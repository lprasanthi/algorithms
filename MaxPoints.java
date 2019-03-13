import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Point {
    public int x;
    public int y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }   
    @Override
    public String toString() {
        return "x "+x+" y "+y;
    }
    @Override
    public int hashCode() {
        return (int)(this.x+this.y);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Point p=(Point)obj;
        return (this.x == p.x) && (this.y == p.y);
    }
}
class Line{
    public double slope;
    public double intercept;
    public Line(double slope,double intercept){
        this.slope=slope;
        this.intercept=intercept;
    }
    public String toString(){
        return "  slope  "+this.slope+"  intercept  "+this.intercept;
    }
    @Override
    public int hashCode() {
        return (int)(this.slope+this.intercept);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Line l=(Line)obj;
        return (this.slope == l.slope) && (this.intercept == l.intercept);
    }
}
public class MaxPoints{

    public static int maxPointsHelper(Point[] points) {
        int max=0;
        if(points.length < 2)
            return points.length;
        for(int i=0;i<points.length;i++){
            HashMap<Line,Integer> map= new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                double slope=Integer.MAX_VALUE;
                double intercept=Integer.MAX_VALUE;
                if(points[i].x == points[j].x){
                    intercept= points[i].x;
                }else{
                   slope = (double)(points[i].y-points[j].y)/(double)(points[i].x - points[j].x);
                   intercept= points[i].y-(slope*points[i].x);
                }
                Line line= new Line(slope,intercept);
                int count= map.getOrDefault(line, 1) + 1;
                map.put(line, count);
                max= Math.max(max, count);
            }
        }
        return max;
    }
    public static Point[] removeDuplicates(Point[] points){
        List<Point> list=new ArrayList<>();
        HashSet<Point> set= new HashSet<>();
        for(int i=0;i<points.length;i++){
            if(!set.contains(points[i])){
                list.add(points[i]);
                set.add(points[i]);
            }
        }
        Point[] newP=new Point[list.size()];
        for(int i=0;i<list.size();i++){
            newP[i]=list.get(i);
        }
        return newP;
    }
    public static int maxPoints(Point[] points) {
        Point[] newP=removeDuplicates(points);
        int max=maxPointsHelper(newP);
        return max+(points.length-newP.length);
    }
    public static void main(String[] args) {
        Point p1= new Point(1,1);
        Point p2= new Point(3,2);
        Point p3= new Point(5,3);
        Point p4= new Point(4,1);
        Point p5= new Point(2,3);
        Point p6= new Point(1,4);
        Point p10= new Point(4,1);
        Point p7= new Point(1,1);
        Point p8= new Point(1,1);
        Point p9= new Point(0,0);
        Point points[] = {p1,p2,p3,p4,p5,p6,p10};
        Point points2[]={p7,p8,p9};
        System.out.println(maxPoints(points));
    }
}