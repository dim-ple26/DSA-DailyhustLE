import java.util.*;
public class djikstraPriorityQueue {

    public int[] algo(int V, List<List<int[]>> adj, int source){
        int[] result = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        Arrays.fill(result, Integer.MAX_VALUE);

        result[source]=0;
        pq.offer(new int[] {0,source});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d=top[0];
            int node=top[1];

            for(int[] vec:adj.get(node)){
                int adjnode = vec[0];
                int dist=vec[1];

                if(d+dist<result[adjnode]){
                    result[node]=d+dist;
                    pq.offer(new int[]{d+dist,adjnode});
                }
            }
        }

        return result;
    }




    
}
