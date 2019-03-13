import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class subSets{
    public static Map<Integer,List<List<Integer>>> getSubsetsHelper(int[] nums,int n){
        Map<Integer,List<List<Integer>>> map=new HashMap<Integer,List<List<Integer>>>();
        if(n == 0){
            List<List<Integer>> list= new ArrayList<List<Integer>>();
            list.add(new ArrayList<Integer>());
            map.put(0,list);
            return map;
        }
        map= getSubsetsHelper(nums, n-1);
        List<List<Integer>> list=map.get(n-1);
        List<List<Integer>> newList= new ArrayList<List<Integer>>();
        for(List<Integer> each : list){
            Collections.sort(each);
            int size= each.size();
            int index=0;
            if(size > 0){
                int lastele=each.get(each.size()-1); 
                index=Arrays.binarySearch(nums, lastele)+1;
            }
            for(int i=index; i!= -1&&i<nums.length;i++){
                List<Integer> temp=new ArrayList<>();
                temp.addAll(each);
                temp.add(nums[i]);
                newList.add(temp);
            }
        }
        map.put(n,newList);
        return map;
    }

    public static List<List<Integer>> getSubsets(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        Map<Integer,List<List<Integer>>> map=getSubsetsHelper(nums,nums.length);
        for(int i: map.keySet()){
            list.addAll(map.get(i));
        }
        return list;
    }

    private static List<List<Integer>> getSubsetsHelper(int[] nums){
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
           int size=list.size();
           for(int j=0;j<size;j++){
               List<Integer> sublist= new ArrayList<>();
               //List<Integer> templist=list.get(j);
               sublist.addAll(list.get(j));
               sublist.add(nums[i]);
               list.add(sublist);
           }     
        }   
        return list;
    }
    public static List<List<Integer>> generateSubSetsEasy(int[] nums){
        // List<Integer> temp= new ArrayList<Integer>(); 
        return getSubsetsHelper(nums);
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> subsets= generateSubSetsEasy(nums);
        System.out.println(subsets);

    }
}