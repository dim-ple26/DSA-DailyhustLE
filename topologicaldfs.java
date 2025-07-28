import java.util.*;

public class topologicaldfs {

    private final List<List<Integer>> adj;
    private final int V;
    private final Stack<Integer> stack;
    private final boolean[] visited;

    public topologicaldfs(int V){
        this.V=V;
        this.adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        this.stack = new Stack<>();
        this.visited= new boolean[V];
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    public  void toposort(){
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private void dfs(int u){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfs(v);

            }
        }
        stack.push(u);
    }

    public static void main(String[] args) {
        topologicaldfs graph = new topologicaldfs(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        System.out.println("Topological sort order: ");
        graph.toposort();
        

    }
    
    
}
