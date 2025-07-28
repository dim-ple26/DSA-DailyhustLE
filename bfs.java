import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
   public static ArrayList<Integer> bfsearch(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[]=new boolean[V];

        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;

   }
    public static void main(String[]args){

        int V =5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        ArrayList<Integer> bfsOrder = bfsearch(V, adj);
        System.out.println("BFS Traversal Order: " + bfsOrder);



    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
}
