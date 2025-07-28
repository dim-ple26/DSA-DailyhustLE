import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class cycledetectionbfs {

    private final int V;
    private final List<Integer>[] adj;
    @SuppressWarnings("unchecked")

    public cycledetectionbfs(int V){
        this.V=V;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);

    }

    private boolean isCycleutil(int current, boolean[] visited){
        int[] parent = new int[V];
        Arrays.fill(parent,-1);

        Queue<Integer> queue = new LinkedList<>();
        visited[current]=true;
        queue.add(current);

        while(!queue.isEmpty()){
            int node =queue.poll();
            for(int neighbor: adj[node]){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    parent[neighbor]=node;
                    queue.add(neighbor);
                }
                else if(parent[node]!=neighbor){
                    return true;
                }

            }
        }
        return false;

    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && isCycleutil(i, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        cycledetectionbfs graph = new cycledetectionbfs(V);

        System.out.println("Enter " + E + " edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does NOT contain a cycle");
        }

    }
    
}
