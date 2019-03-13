public class rotateArray{
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[]={1,2,3,4,5,6,7};
        s.rotate(nums, 4); 
        s.print(nums);  
    }
}

class Solution{
    public void reverse(int[] nums,int start,int end){
       for(int i=start; i < end; i++,end--){
            int temp = nums[i];
            nums[i]= nums[end];
            nums[end]= temp;
        }
    }
    public void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }
    public void rotate(int[] nums, int k){      
       if(k>nums.length){
           k = k%nums.length;
       }
       int mid = nums.length-k-1;
       int end= nums.length-1;
       reverse(nums, 0, mid);
       reverse(nums, mid+1, end);
       reverse(nums,0,end);
    }
}