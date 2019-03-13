public class StringPalindrome{
    public static boolean isPalindrome(String s) {
        int j=s.length()-1;
        int i=0;    
        while(i<j && i<s.length() && j>=0){
            while(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i<j && i<s.length() && j>=0){
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab"));
    }
}