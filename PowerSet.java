import java.util.ArrayList;

public class PowerSet{
    public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> mainset = new ArrayList<ArrayList<Integer>>();
        if(index == 0){
            mainset.add(new ArrayList<Integer>());
            return mainset;
        }
        ArrayList<ArrayList<Integer>> allsets=getSubSets(set, index-1);
        for(ArrayList<Integer> list : allsets){
            int size=list.size();
            int i=0;
            if(size > 0){
                int lastele =list.get(size-1);
                i=set.indexOf(lastele)+1;
            } 
            while(i<set.size()){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(list);
                temp.add(set.get(i));
                mainset.add(temp);
                i++;
            }
        }
        return mainset;
    }
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        ArrayList<ArrayList<Integer>> ps= getSubSets(set,4);
        for(ArrayList<Integer> list : ps){
            for(Integer i : list)
                System.out.print(i+",");
            System.out.println();
        }
    }
}