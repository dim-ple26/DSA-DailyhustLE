import java.util.*;

public class kahnsalgo {

    public int[] toposort(int N, ArrayList<ArrayList<Integer>> adj){

        Queue<Integer> queue= new LinkedList<>();
        int[] indegree= new int[N];

        for(int u=0;u<N;u++){
            for(int v:adj.get(u)){
                indegree[v]++;

            }
        }

        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int[] result= new int[N];
        int index=0;
        while(!queue.isEmpty()){
            int u= queue.poll();
            result[index++]=u;

            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
         kahnsalgo sol = new kahnsalgo();
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         int N = 6;

         for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
         }

         adj.get(0).add(3);
         adj.get(0).add(2);
         adj.get(3).add(1);
         adj.get(2).add(3);
         adj.get(2).add(1);
         adj.get(1).add(4);
         adj.get(5).add(1);
         adj.get(5).add(4);

         int[] result = sol.toposort(N,adj);
         System.out.println("Topological sort");
         for(int i=0;i<N;i++){
            System.out.print(result[i]+" ");
         }
    }


    
}
