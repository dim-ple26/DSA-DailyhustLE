package RecursionANDBacktracking;

public class perfectsum {
    class Solution {
        // Function to calculate the number of subsets with a given sum
        
        public int f(int i, int[] nums, int s,int target){
            int n=nums.length;
            
            if(i==n){
                return (s==target)?1 :0;
            }
            
            
            
            return f(i+1,nums,s+nums[i],target)+f(i+1,nums,s,target);
        }
        public int perfectSum(int[] nums, int target) {
            // code here
            
            return f(0,nums,0,target);
    
        }
    }}





    
        // Function to calculate the number of subsets with a given sum
        
//       //  public int f(int i,ArrayList<Integer> ds, int[] nums, int s,int target){
//             int n=nums.length;
//             int count=0;
//             if(i==n){
//                 if(s==target){
//                     count++;
//                     System.exit(0);
//                 }
//             }
            
//             ds.add(nums[i]);
//             s+=nums[i];
//             f(i+1,ds,nums,s,target);
//             ds.remove(nums[i]);
//             s-=nums[i];
//             f(i+1,ds,nums,s,target);
            
//             return count;
//         }
//         public int perfectSum(int[] nums, int target) {
//             // code here
//             // ArrayList<Integer> ds = new ArrayList<>();
//             int s =0;
//             int res = f(0,ds,nums,s,target);
//             return res;
    
//         }
    
    
// }
