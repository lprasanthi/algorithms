import java.util.ArrayList;
import java.util.HashSet;

public class StringPermutation{
    public static String position(String input,int i,char n){
        if(i == 0){
            return String.valueOf(n)+input;
        }
        String str1=input.substring(0, i);
        String str2=String.valueOf(n);
        String str3=input.substring(i, input.length());
        return str1+str2+str3;
    }
    public static ArrayList<String> PermutateHelper(char[] input,int n){
        ArrayList<String> mainlist= new ArrayList<String>();
        if(n == 1){
            mainlist.add(String.valueOf(input[0]));
            return mainlist;
        }
        ArrayList<String> sublist = PermutateHelper(input, n-1);
        for(String each : sublist){
            for(int i=0; i<=each.length(); i++)
                mainlist.add(position(each,i,input[n-1]));
        }     
        return mainlist;
    }
    public static ArrayList<String> Permutate(String input){
        char[] str=input.toCharArray();
        return PermutateHelper(str,4);
    }

    public static ArrayList<String> PermutateHelperDuplicate(char[] input,int n,HashSet<String> set){
        ArrayList<String> mainlist= new ArrayList<String>();
        if(n == 1){
            String temp= String.valueOf(input[0]);
            set.add(temp);
            mainlist.add(temp);
            return mainlist;
        }
        ArrayList<String> sublist = PermutateHelper(input, n-1);
        for(String each : sublist){
            for(int i=0; i<=each.length(); i++){
                String temp=position(each,i,input[n-1]);
                if(!set.contains(temp)){
                    mainlist.add(temp);
                    set.add(temp);
                }
            }
        }     
        return mainlist;
    }

    public static ArrayList<String> PermutateDuplicate(String input){
        char[] str=input.toCharArray();
        HashSet<String> set=new HashSet<String>();
        return PermutateHelperDuplicate(str,4,set);
    }
    public static void main(String[] args) {
        String str="abcd";
        String str2="aabc";
        ArrayList<String> list = Permutate(str);
        ArrayList<String> list2 = PermutateDuplicate(str2);
        System.out.println("No of permutations is "+list.size());
        for(String temp : list)
            System.out.println(temp);
        System.out.println("No of permutations with Duplicate is "+list2.size());
        for(String temp : list2)
            System.out.println(temp);
    }
}