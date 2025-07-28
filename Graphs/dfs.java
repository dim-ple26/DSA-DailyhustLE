import java.util.ArrayList;
import java.util.Scanner;

public class dfs {

    public static ArrayList<Integer> dfsearch(int V , ArrayList<ArrayList<Integer>> adj, int src){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[]= new boolean[V];

        helper(src,adj,vis,ans);
        return ans;
    }

    private static void helper(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> ans){
        vis[0]=true;
        ans.add(node);

        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                helper(it, adj, vis, ans);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of vertices and edges:");
         
        int V = sc.nextInt();
        int E = sc.nextInt();

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int src = sc.nextInt();
        ArrayList<Integer> result= dfsearch(V, adj,src);

        System.out.println("DFS Traversal Order: " + result);

    }
    
}
