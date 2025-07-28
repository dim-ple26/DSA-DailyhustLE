import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class courseschedule1 {

    public boolean topo(Map<Integer,List<Integer>> adj, int n , int[] indegree){
        Queue<Integer> que = new LinkedList<>();
        int count=0;

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                count++;
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int u=que.poll();
            for(int v:adj.getOrDefault(u,new ArrayList<>())){
                indegree[v]--;
                if(indegree[v]==0)
                {
                    count++;
                    que.add(v);
                }
            }
        }
        return count==n;
    }

    public boolean canFinish(int numcourses,int[][] prereq)
    {
        Map<Integer, List<Integer>> adj =  new HashMap<>();
        int[] indegree= new int[numcourses];
        for(int[] vec : prereq){
            int a=vec[0];
            int b = vec[1];
            adj.computeIfAbsent(b, k->new ArrayList<>()).add(a);
            indegree[a]++;
        }
        return topo(adj, numcourses, indegree);
    }

    public static void main(String[] args) {
        courseschedule1 sol = new courseschedule1();
        int numcourses=2;
        int[][] prereq = {{1,0}};
        boolean result= sol.canFinish(numcourses, prereq);
        System.out.println("can finish all courses: "+ result);


        int numcourses1=2;
        int[][] prereq1 = {{1,0}, {0,1}};
        boolean result1= sol.canFinish(numcourses1, prereq1);
        System.out.println("can finish all courses: "+ result1);

    }
    
}
