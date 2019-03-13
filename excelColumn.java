public class excelColumn{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getColumn("AA"));   
    }
}

class Solution{
    public int toIntHelper(char s){
        return (int)s - (int)'A'+1;
    }
    public int getColumn(String s){
        int sum =0;
        int count=1;
        for(int i=s.length()-1; i>=0;i--){
            sum = sum+(toIntHelper(s.charAt(i))*count);
            count = count*26;
        }
        return sum;
    }
}