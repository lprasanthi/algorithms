import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class groupAnagrams{
    public static String[] sortByAnagrams(String[] arr){
       HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
       for(int i=0;i<arr.length;i++){
           char key[]=arr[i].toCharArray();
           Arrays.sort(key);
           String sortedKey=String.valueOf(key);
           if(map.containsKey(sortedKey)){
                ArrayList<String> list=map.get(sortedKey);
                list.add(arr[i]);
           }else{
            ArrayList<String> list = new ArrayList<String>();
            list.add(arr[i]);
            map.put(sortedKey, list);
           }
       }
       String anagrams[]=new String[arr.length];
       int i=0;
       for(String key:map.keySet()){
           ArrayList<String> list=map.get(key);
           for(String each:list){
                anagrams[i]= each;
                i++;
           }
       }
       return anagrams;
    }
    public static void main(String[] args) {
        String arr[]={"race","pen","pencil","cart","care","ract","acre"};
        String sortedarr[]=sortByAnagrams(arr);
        for(int i=0;i<sortedarr.length;i++)
            System.out.println(sortedarr[i]);
    }
}