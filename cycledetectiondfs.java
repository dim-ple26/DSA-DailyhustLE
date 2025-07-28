import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cycledetectiondfs{

    private final int V;
    private final List<Integer>[] adj;
    @SuppressWarnings("unchecked")

    public cycledetectiondfs(int V){
        this.V = V;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    @SuppressWarnings("unused")
    private boolean isCycleutil(int current, boolean[] visited, int parent){
        visited[current]=true;

        for(int neighbor : adj[current]){
            if(neighbor == parent) continue;
            if(visited[neighbor]) return true;
            if(isCycleutil(neighbor, visited, current)) return true;
        }
        return false;
    }

    public boolean isCyclic() {
        boolean []visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && isCycleutil(i, visited, -1)){
                return true;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter v and e");
        int V = sc.nextInt();
        int E = sc.nextInt();

        cycledetectiondfs g = new cycledetectiondfs(V);

        System.out.println("Enter " + E + " edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

         if (g.isCyclic()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does NOT contain a cycle");
        }
    }
    
}
