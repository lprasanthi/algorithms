import java.util.ArrayList;
import java.util.HashSet;

public class ParenthesisGenerator{
    public static String position(String data,int n){
        if(n == 0){
            return "()"+data;
        }
        int count =1;
        //System.out.println("entered"+n);
        for(int i=0;i<data.length();i++){
            if(data.charAt(i) == '('){
                if(count == n){
                    System.out.println("i "+i+" count "+count);
                    return data.substring(0, i+1) + "()" + data.substring(i+1,data.length());
                }
                count++;
            }
        }
        return null;
    }
    public static ArrayList<String> generateParenHelper(int n, HashSet<String> set){
        ArrayList<String> mainlist = new ArrayList<String>();
        if(n == 1){
            mainlist.add("()");
            set.add("()");
            return mainlist;
        }
        ArrayList<String> sublist= generateParenHelper(n-1,set);
        for(String each:sublist){
            for(int i=0;i<=each.length()/2;i++){
               // System.out.println("each "+each);
                String temp=position(each,i); 
               // System.out.println("temp "+temp); 
                if(!set.contains(temp)){
                    set.add(temp);
                    mainlist.add(temp);
                }
            }
        }
        return mainlist;
    }
    public static ArrayList<String> generateParen(int n){
        return generateParenHelper(n,new HashSet<String>());
    }
    public static void main(String[] args) {
        ArrayList<String> list=generateParen(3);
        for(String each:list)
            System.out.println(each);
    }
}