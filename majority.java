import java.util.Arrays;
public class majority{

    public static void main(String []args){
        Solution s = new Solution();
        int nums[]= {6,6,6,7,7};
        System.out.println(s.majorityElement(nums));
     }
}
class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
       int count=0;
       int greatestOccuranceCount=0;
       int greatestOccurance=nums[0];
       int i=0;
       while(i < nums.length - 1) {
          if(nums[i] == nums[i+1])
            count++;
          else{
            if(count > greatestOccuranceCount){
                greatestOccuranceCount = count;
                greatestOccurance = nums[i];
            }
            count=0;
          }
          i++;
       }
       if(count > greatestOccuranceCount){
            greatestOccuranceCount = count;
            greatestOccurance = nums[i];
        }
       return greatestOccurance;
    }
}
