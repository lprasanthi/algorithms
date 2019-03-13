import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKWords{
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for (String word : words) {
            int count=map.getOrDefault(word, 0);
            count++;
            map.put(word,count);
        }
        List<String> list= new ArrayList<>(map.keySet());
        System.out.println(map);
        Collections.sort(list, (w1,w2) -> (map.get(w1)==map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return list.subList(0, k);
    }
    public static void main(String[] args) {
       String[] input={"i", "love", "leetcode", "i", "love", "coding"}; 
       List<String> words= topKFrequent(input, 2);
       System.out.println(words);
    }
}