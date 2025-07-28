import java.util.Arrays;

public class BellmanFordAlgo {
    
}
// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dist[]= new int[V];
        Arrays.fill(dist, 100000000);
        dist[src]=0;
        
        for(int count=1;count<=V-1;count++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u]!=100000000 && dist[u]+w< dist[v]){
                    dist[v]=dist[u]+w;
                    
                }
            }
        }
        int neg[]={-1};
        for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u]!=100000000 && dist[u]+w< dist[v]){
                    return new int[] {-1};
                    
                }
            }
            
        return dist;
        
        
    }
}

