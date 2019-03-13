import java.util.List;
import java.util.ArrayList;

class Interval{
    int start,end;
    public Interval(){
        this.start=0;
        this.end=0;
    }
    public Interval(int s,int e){
        this.start=s;
        this.end=e;
    }
    public String toString(){
        return "["+this.start+","+this.end+"]";
    }
}
public class mergeOverlaps{
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list= new ArrayList<Interval>();
        if(intervals.size()<=1)
            return intervals;
        intervals.sort((i1,i2) -> Integer.compare(i1.start, i2.start));
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(Interval interval:intervals){
            if(interval.start<=end){
                end=Math.max(end,interval.end);
            }else{
                list.add(new Interval(start,end));
                start=interval.start;
                end=interval.end;
            }
        }
        list.add(new Interval(start,end));
        return list;
    }
    public static void main(String[] args) {
        List<Interval> intervals= new ArrayList<Interval>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,17));
        intervals.add(new Interval(18,23));
        intervals.add(new Interval(23,30));
        List<Interval> overlapped=merge(intervals);
        //for(Interval interval:overlapped)
        System.out.println(overlapped);
    }
}