import java.util.HashMap;

public class twoSum{
    private static int[] get2Sum(int[] nums,int target){
        int indexes[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                indexes[0]=map.get(diff);
                indexes[1]=i;
                return indexes;
            }
            map.put(nums[i], i);
        }
        return indexes;
    }
    public static void main(String[] args) {
        int[] num={2,4,-5,6,7};
        int target=9;
        int[] indexes=get2Sum(num,target);
        System.out.println(indexes[0]);
        System.out.println(indexes[1]);
    }
}