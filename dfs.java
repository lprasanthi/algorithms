import java.util.ArrayList;
import java.util.List;

class Node{
    public int data;
    public List<Node> edges;
    private boolean visited;
    public Node(int data){
        this.data=data;
        this.edges=new ArrayList<>();
        this.visited=false;
    }
    public void addEdge(Node adj){
        this.edges.add(adj);
        // undirected graph
        // adj.edges.add(this);
    }
    public void visit(){
        this.visited=true;
    }
    public boolean isVisited(){
        return this.visited;
    }
}
class Graph{
    public List<Node> nodes;
    public Graph(List<Node> nodes){
        this.nodes=nodes;
    }
}

public class dfs{
    private static List<Node> visited=new ArrayList<>(); 
    private static void visit(Node n){
        n.visit();
        //visited.add(n);
        System.out.println(n.data);
    }
    public static void depthFirstSearch(Node root){
        if(root == null)
            return;
        visit(root);

        for (Node adj : root.edges) {
            if(!adj.isVisited()){
                depthFirstSearch(adj);
            }
        }
    }
    public static void bfs(Node root){
        List<Node> queue=new ArrayList<>();
        visit(root);
        queue.add(root);
        while(queue.size() != 0){
            Node visiting=queue.remove(0);
            for (Node adj : visiting.edges) {
                if(!adj.isVisited()){
                    visit(adj);
                    queue.add(adj);
                }
            }
        }
    }
    public static void main(String[] args) {
        List<Node> nodes= new ArrayList<Node>();
        for(int i=0;i<6;i++){
            nodes.add(new Node(i));
        }
        nodes.get(0).addEdge(nodes.get(3));
        nodes.get(1).addEdge(nodes.get(2));
        nodes.get(3).addEdge(nodes.get(1));
        nodes.get(2).addEdge(nodes.get(3));
        nodes.get(3).addEdge(nodes.get(4));
        nodes.get(4).addEdge(nodes.get(2));

        Graph g= new Graph(nodes);
       // depthFirstSearch(nodes.get(0));
        System.out.println("BFS");
        bfs(nodes.get(0));

        
    }
}