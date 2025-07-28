import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduletwo {



    public int[] findOrder(int numcourses, int[][] prereq){
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int [] indegree= new int[numcourses];

        for(int[] vec: prereq){
            int a = vec[0];
            int b=vec[1];

            adj.computeIfAbsent(b,k->new ArrayList<>()).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numcourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int[] result= new int[numcourses];
        int index=0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            result[index++]=u;
            for(int v: adj.getOrDefault(u,new ArrayList<>())){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);

                }
            }
        }

        if(index!=numcourses){
            return new int[0];
        }
        return result;
    }


    public static void main(String[] args) {

        CourseScheduletwo sol = new CourseScheduletwo();
        int numcourses=4;
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        int[] result= sol.findOrder(numcourses, pre);
        System.out.println("Courses order: ");
        for(int course: result){
            System.out.print(course+" ");
        }
        
    }
    
}
