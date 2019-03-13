import java.util.ArrayList;
import java.util.List;

public class CommonCharacters{
    public static List<String> commonChars(String[] A) {
        List<String> list=new ArrayList<>();
        int[] hash=new int[26];
        for(int i=0;i<26;i++){
            hash[i]= Integer.MAX_VALUE;
        }
        for(String word: A){
            int[] temp= new int[26];
            for(char s: word.toCharArray()){
                int index=s-'a';
                temp[index]= temp[index]+1;
            }
            for(int i=0;i<26;i++){
                hash[i]= Math.min(hash[i], temp[i]);
            }
        }
        for(int i=0;i<26;i++){
            int val=hash[i];
            for(int k=0;k<val;k++){
                list.add(String.valueOf((char)('a'+i)));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String[] input={"bella","label","roller"};
        List<String> chars= commonChars(input);
        System.out.println(chars);
    }
}