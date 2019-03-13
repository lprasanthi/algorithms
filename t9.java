import java.util.ArrayList;

public class t9{
    public static ArrayList<String> generateWords(String digits){
        if(digits.length() == 0)
            return null;
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();i++){
            int digit=Character.getNumericValue(digits.charAt(i));
            String possibilities=map[digit];
            int size=list.size();
            for(int j=0;j<size;j++){
                String temp=list.remove(0);
                for(int k=0;k<possibilities.length();k++){
                    String word= temp+possibilities.charAt(k);
                    list.add(word);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        ArrayList<String> s= generateWords("23");
        for(String each:s){
            System.out.println(each);
        }
    }
}