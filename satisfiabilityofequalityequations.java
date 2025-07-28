//lc- 990
// https://leetcode.com/problems/satisfiability-of-equality-equations/description/
class Solution {
        int parent[] = new int[26];
        int rank[] = new int[26];

    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }

    }


    public boolean equationsPossible(String[] equations) {

        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=i;
        }

        for(String eq : equations){
            if(eq.charAt(1)=='='){
                int a = eq.charAt(0)-'a';
                int b = eq.charAt(3)-'a';
                union(a,b);
            }

        }

        for(String eq: equations){
            if(eq.charAt(1)=='!'){
                int a = eq.charAt(0)-'a';
                int b = eq.charAt(3)-'a';
                if(find(a)==find(b)){
                    return false;
                }
            }
        }

        return true;



        
    }
}