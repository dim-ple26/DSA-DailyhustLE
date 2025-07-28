import java.util.Arrays;

class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color,-1);


        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!dfs(graph,i,color,1)){
                    return false;
                }
            }
        }
        return true;


        
    }

    private boolean dfs(int[][] graph, int curr, int[] color, int currcolor){
        color[curr]=currcolor;

        for(int v: graph[curr]){
            if(color[v]==color[curr]){
                return false;
            }

            if(color[v]==-1){
                if(!dfs(graph,v,color,1-color[curr])){
                    return false;
                }
            }
        }
        return true;
    }
}