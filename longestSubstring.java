import java.util.HashMap;

public class longestSubstring{
    public static int getLength(String s){
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int ans=0,index=-1;
        int i=0;
        for(int j=0;j<s.length();j++){
            int length= j-i+1;
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), j);
            }else if(map.get(s.charAt(j)) < i){
                map.put(s.charAt(j), j);
            } else {
                length--;
                i=map.get(s.charAt(j))+1;
                map.put(s.charAt(j), j);
            }
            if(ans < length){
                ans=length;
                index=i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="abcabcdef";
        System.out.println("Length of longest substring of "+s+"is "+getLength(s));
    }
}