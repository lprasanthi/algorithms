public class reverseWords{
    public static int trimTrailingSpaces(String s,int n){
        int end=n;
        while(end>=0 && s.charAt(end)==' '){
            end--;
        }
        return end;
    }
    public static int trimStartingSpaces(String s){
        int start=0;
        while(start<s.length() && s.charAt(start)==' '){
            start++;
        }
        return start;
    }
    //more optimal
    public static String reverseWordsOf(String s) {
        StringBuilder reversedS= new StringBuilder();
        int n=s.length()-1;
        int cur=Integer.MAX_VALUE;
        int start=trimStartingSpaces(s);
        while(cur>0){
            int end=trimTrailingSpaces(s, n);
            if(end<0){
                return reversedS.toString();
            }
            cur=end;
            while(cur>=0 && s.charAt(cur) != ' '){
                cur--; 
            }
            reversedS.append(s.substring(cur+1,end+1));
            if(cur>=start)
                reversedS.append(" ");
            n=cur;
        }
        return reversedS.toString();
    }
    public static String reverseWordsOf2(String s) {
        StringBuilder reversedS= new StringBuilder();
        String[] tokens=s.trim().split("\\s+");
        for(int i=tokens.length-1;i>=0;i--){
            reversedS.append(tokens[i]);
            reversedS.append(" ");
        }
        return reversedS.toString().trim();
    }
    
    public static void main(String[] args) {
        int length=reverseWordsOf2(" 1").length();
        System.out.println(reverseWordsOf2("the sky is blue")+length);
    }
}