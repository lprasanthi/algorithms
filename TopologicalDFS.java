import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// class Vertex{
//     public int data;
//     public boolean visited;
//     public boolean visiting;
//     public GraphNode[] children;
//     public Vertex(int data){
//         this.data=data;
//         this.visited=false;
//         this.visiting=false;
//     }
// }
class Graph{
    public int V; // number of vertices
    public List<List<Integer>> adj; // array of "list of adjacent vertices"
    public Graph(int V){
        this.V=V;
        adj=new ArrayList<List<Integer>>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int start, int end){
        adj.get(start).add(end);
    }
}
public class TopologicalDFS{
    public static Graph constructGraph(int numCourses,int[][] prerequisites){
        Graph graph=new Graph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        return graph;
    }
    public static boolean DFS(int vertex,Stack<Integer> s,boolean visited[],boolean visiting[],Graph graph){
        visiting[vertex]=true;
        boolean acyclic=true;
        List<Integer> children=graph.adj.get(vertex);
        for(int i=0;i<children.size() && acyclic;i++){
            int edge=children.get(i);
            if(!visited[edge]){
                if(visiting[edge]){
                    //acyclic=false;
                    return false;
                }else{
                    acyclic=DFS(edge, s, visited, visiting, graph);
                }
            }
        }
        if(!acyclic)
            return false;
        //System.out.println("entered here vertex "+vertex);
        visiting[vertex]=false;
        visited[vertex]=true;
        s.push(vertex);
        return true;
    }
    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        int[] order=new int[numCourses];
        int notfound[]={};
        if(numCourses <= 0)
            return notfound;
        Graph graph=constructGraph(numCourses,prerequisites);
        Stack<Integer> stack=new Stack<Integer>();
        boolean[] visited=new boolean[numCourses+1];
        boolean[] visiting=new boolean[numCourses+1];
        for(int i=0;i<numCourses;i++){
            visited[i]=false;
        }
        for(int i=0;i<numCourses;i++){
            visiting[i]=false;
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                boolean isDAG=DFS(i,stack,visited,visiting,graph);
                if(!isDAG)
                    return notfound;
            }
        }
        int i=0;
        order=new int[numCourses];
        while(!stack.isEmpty()){
            order[i++]=stack.pop();
        }
        return order;
    }
    public static void main(String[] args) {
        int numCourses=6;
        int prerequisites[][]={{0,3},{5,1},{1,3},{5,0},{3,2}};
        int order[]=canFinish(numCourses,prerequisites);
        for (int i : order) {
            int a='a'+i;
            char test=(char)a;
            System.out.println(test+", ");
        }
        System.out.println(canFinish(numCourses,prerequisites));
    }
}