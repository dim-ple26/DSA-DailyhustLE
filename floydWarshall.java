public class floydWarshall {
    
}
class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        final int INF = 100000000; // 1e8 as given in the problem

        // Floyd-Warshall algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Prevent integer overflow by checking if via-paths are valid
                    if (dist[i][via] != INF && dist[via][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }
    }
}
