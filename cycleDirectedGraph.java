import java.util.ArrayList;

public class cycleDirectedGraph {

    private boolean isCycledfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion){

        visited[u]=true;
        inRecursion[u]=true;

        for(int v:adj.get(u)){
            if(!visited[v] && isCycledfs(adj, v, visited, inRecursion)){
                return true;
            }
            else if(inRecursion[v]) return true;
        }


        return false;

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited= new boolean[V];
        boolean[] inRecursion= new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i] && isCycledfs(adj, i, visited, inRecursion)){
                return true;
            }
        }
        return false;
    
    }

    public static void main(String[] args) {
        cycleDirectedGraph sol = new cycleDirectedGraph();
        int V =4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);

        boolean isc=sol.isCycle(V, adj);
        System.out.println("graph contains cycle "+isc);

    }
    
}
