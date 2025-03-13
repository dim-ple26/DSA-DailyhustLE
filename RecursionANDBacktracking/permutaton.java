package RecursionANDBacktracking;

import java.util.ArrayList;
import java.util.List;

public class permutaton {

    public void solve(int[] nums,List<List<Integer>> ans, int index){
        if(index>=nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=index;j<nums.length;j++){
            swap(nums,index,j);
            solve(nums,ans,index+1);
            swap(nums,index,j);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int index=0;
        solve(nums,ans,index);
        return ans;
        
    }
    
}
