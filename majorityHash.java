import java.util.HashMap;
import java.util.Map;

public class majorityHash{
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {1,2,2,2};
        System.out.println(s.majorityElement(nums));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int majorityEle=-1;
        Map<Integer,Integer> occurance = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            int count=1;
            if(occurance.containsKey(nums[i])){
                count =occurance.get(nums[i]).intValue() + 1;
            }
            occurance.put(nums[i], count);
        } 
        for(Map.Entry<Integer,Integer> entry : occurance.entrySet()){
            if(entry.getValue().intValue()> nums.length/2)
                majorityEle= entry.getKey();
        }
        return majorityEle;
    }
}