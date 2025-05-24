class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
            
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.distance));
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;
            
            
            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int weight = neighbor[1];
                
                if(d+weight<dist[v]){
                    dist[v]=d+weight;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
        
        return dist;
        // code here
        
    }
    
    static class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node = node;
            this.distance= distance;
        }
    }
}