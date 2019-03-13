public class jumpGame{
    public static boolean canJump(int[] nums) {
        int max=0,i=0;
        while(i<=max && max<=nums.length-1){
            int temp=i+nums[i];
            max=Math.max(max,temp);
            i++;
        }
        return max>=nums.length-1;
    }
    public static void main(String[] args) {
        int[] nums={2, 3, 2, 1, 0, 2, 0};
        System.out.println(canJump(nums));
    }
}