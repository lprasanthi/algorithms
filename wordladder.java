import java.util.*;

public class wordladder{
    private static List<String> findNeighbours(String beginWord,List<String> wordList){
        int i=0;
        List<String> neighbours= new ArrayList<>();
        for(String word: wordList){
            for(int j=0;j< word.length();j++){
                if(word.charAt(j) != beginWord.charAt(j)){
                    i++;
                }
            }
            if(i == 1){
                neighbours.add(word);
            }
            i=0;
        }
        return neighbours;
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level=0;
        HashMap<String,List<String>> graph= new HashMap<String,List<String>>();
        Set<String> visitSet= new HashSet<>();
        if(!wordList.contains(endWord)){
            return level;
        }
        graph.put(beginWord,findNeighbours(beginWord, wordList));
        for(String word: wordList){
            graph.put(word, findNeighbours(word, wordList));
        }
        System.out.println(graph);
        List<String> neighbours = graph.get(beginWord);
        level++;
        while(!neighbours.isEmpty()){
            int size=neighbours.size();
            for(int i=0;i<size;i++){
                String word=neighbours.remove(0);
                if(word.equals(endWord))
                    return level;
                if(!visitSet.contains(word)){
                    neighbours.addAll(graph.get(word));
                    visitSet.add(word);
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String> wordList= new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        //String wordList[] = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit";
        String endWord = "cog";
        int length=ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }
}