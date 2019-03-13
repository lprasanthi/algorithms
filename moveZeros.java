public class moveZeros{
    public static void move0s(int[] nums){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
        }
        for(;count<nums.length;count++){
            nums[count]=0;
        }
    }
    public static void main(String[] args) {
        int[] nums={1,0,3,4,0,0,5,12};
        move0s(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}