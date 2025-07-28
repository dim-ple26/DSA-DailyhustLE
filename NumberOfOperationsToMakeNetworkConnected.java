
// lc-1391
class Solution {
    int[] parent;
    int[] rank;

    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);

        if(xparent==yparent) return;
        if(rank[xparent]>rank[yparent]){
            parent[yparent]=xparent;

        }
        else if(rank[xparent]<rank[yparent]){
            parent[xparent]=yparent;
        }
        else{
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1) return -1;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        int components=n;
        for(int[] conn:connections){
            if(find(conn[0])!=find(conn[1])){
                union(conn[0],conn[1]);
                components--;
            }
        }

        return components-1;
        
    }
}