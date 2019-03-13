import java.util.Arrays;
import java.util.Comparator;

public class buildLargestNumber{
    public static String largestNumber(int[] nums) {
        StringBuilder s= new StringBuilder();
        String str[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Comparator<String> comp= new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                String str1=s1+s2;
                String str2=s2+s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(str,comp);
        if(str[0].charAt(0) == '0')
            return String.valueOf(0);
        for (String ite : str) {
            s.append(ite);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        int input[]={3,30,34,5,9};
        System.out.println(largestNumber(input));  
    }
}