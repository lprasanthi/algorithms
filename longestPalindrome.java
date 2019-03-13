
public class longestPalindrome{
    public static String getPossiblePalindrome(String s,int mid){
        int i=mid-1;
        int j=mid+1;
        if(j>s.length()-1){
            j=mid;
        }else if(i < 0){
            i=mid;
        }else if(s.charAt(i) != s.charAt(j)){
            j=mid;
        }
        while(i>=0 && j< s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }
        i++;
        System.out.println("i and j "+i+" "+j);
        return s.substring(i, j);
    }
    public static String getLongest(String s,int low,int high,String answer){
        if(s.length() <= 1)
            return s;
        if(low >= high)
            return answer;
        int mid=(low+high)/2;
        System.out.println("low,high,mid "+low+high+mid);
        String temp=getPossiblePalindrome(s,mid);
        if(temp.length() > answer.length()){
            answer=temp;
        }
        answer=getLongest(s,low,mid,answer);
        answer=getLongest(s, mid+1, high,answer);
        return answer;
    }
    public static void main(String[] args) {
        String s="bb";
        System.out.println("Longest is"+getLongest(s,0,s.length()-1,""));
    }
}