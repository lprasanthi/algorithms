import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// class Graph{
//     String name;
//     List<Graph> connections;
//     public Graph(String name){
//         this.name=name;
//         connections=new ArrayList<Graph>();
//     }
//     public addConnection(Graph src, Graph dest){
//         List<Graph> connectionList= src.connections;
//         int size=connectionList.size();
//         for (Graph cur : connectionList) {
//             if(dest.name.compareTo(cur.name) > 0){
//                 connectionList.add(i, dest);   
//            } 
//         }
//         if(connectionList.size() == size){
//             connectionList.add(dest);
//         }
//     }
// }

public class ReconstructItinerary{
    public static Map<String,List<String>> buildGraph(String[][] tickets){
        Map<String, List<String>> airports=new HashMap<String,List<String>>();
        for(int i=0;i<tickets.length;i++){
            for(int j=0;j<tickets[i].length-1;j++){
                String destination= tickets[i][j+1];
                String source= tickets[i][j];
                if(!airports.containsKey(source)){
                    List<String> destinations = new ArrayList<>();
                    airports.put(tickets[i][j], destinations);
                }
                List<String> destinations = airports.get(source);
                destinations.add(destination);
                Collections.sort(destinations);
            }
        }
        return airports;
    }
    private static void DFS(List<String> reorderedList,Map<String, List<String>> airports, String source,int length){
        if(!airports.containsKey(source)){
            return;
        }
        List<String> destinations = airports.get(source);
        int size=destinations.size();
        for(int i=0;i< size;i++){
            String cur= destinations.remove(0);
            reorderedList.add(cur);
            DFS(reorderedList, airports, cur,length);
            if(reorderedList.size() < length+1){
                destinations.add(cur);
                int last=reorderedList.size()-1;
                reorderedList.remove(last);
            }else if(reorderedList.size() == length+1){
                return;
            }
        }
        return;
    }
    public static List<String> search(Map<String, List<String>> airports, String start, int length){
        List<String> reorderedList= new ArrayList<>();
        reorderedList.add(start);
        DFS(reorderedList,airports,start,length);
        return reorderedList;
    }
    public static List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> airports=buildGraph(tickets);
        List<String> reorderedList=search(airports, "JFK", tickets.length);
        return reorderedList;
    }
    public static void main(String[] args) {
        String[][] tickets={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets1= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tickets3={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tickets4={{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        List<String> list= findItinerary(tickets1);
        System.out.println(list);
    }
}