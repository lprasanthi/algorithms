public class sortColors{
    public static int[] sortColors(int[] nums){
        int op=0,tp=nums.length-1;
        for(int i=0;i<nums.length;i++){
            //System.out.println();
            // System.out.println("i "+i+" op "+op+" tp "+tp);
            // for(int k=0;k<nums.length;k++){
            //     System.out.print(nums[k]+" , ");
            // }
            // System.out.println();
            while(nums[i] == 0 && i>op){
                int temp=nums[i];
                nums[i]=nums[op];
                nums[op]=temp;
                op++;
                // System.out.println("entered nums[i] "+nums[i]+" op "+op);
            }
            while(nums[i] == 2 && i<=tp){
                int temp=nums[i];
                nums[i]=nums[tp];
                nums[tp]=temp;
                tp--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int nums[]={0,0,2,1,1,0};
        int sorted[]= sortColors(nums);
        for(int i=0;i<sorted.length;i++)
            System.out.println(sorted[i]);
    }
}