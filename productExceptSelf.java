public class productExceptSelf{
    public static int[] productExceptSelfArray(int[] nums) {
        int temp=1;
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=temp;
            temp=temp*nums[i];
        }
        temp=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*temp;
            temp=temp*nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int input[]={1,2,3,4};
        int output[]=productExceptSelfArray(input);
        for(int i=0;i<input.length;i++){
            System.out.println(output[i]);
        }
    }
}