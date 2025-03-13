package RecursionANDBacktracking;
import java.util.*;
public class mColoring {




    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        List<Integer>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int colors[]= new int[v];
        
        return solve(0,graph,colors,m,v);
    }
    
    boolean solve(int node,List<Integer>[] graph,int[] colors,int m,int v){
        if(node==v){
            return true;
        }
        for(int color=1;color<=m;color++){
            if(isSafe(node,graph,colors,color)){
                colors[node]=color;
                
                if(solve(node+1,graph,colors,m,v)){
                    return true;
                }
                colors[node]=0;
            }
        }
        return false;
    }
    
    boolean isSafe(int node,List<Integer>[] graph,int[] colors,int color){
        for(int neighbour:graph[node]){
            if(colors[neighbour]==color){
                return false;
            }
        }
        return true;
    }
}
    

