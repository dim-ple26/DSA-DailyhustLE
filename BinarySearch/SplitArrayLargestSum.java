package BinarySearch;

public class SplitArrayLargestSum {

    public static int countpartitions(int[] nums,int maxsum){
        int n=nums.length;
        int pi=1;
        long  subsum=0;
        for(int i=0;i<n;i++){
            if(subsum+nums[i]<=maxsum){
                subsum+=nums[i];
            }else{
                pi++;
                subsum=nums[i];
            }
        }
        return pi;
    }
    public int splitArray(int[] nums, int k) {
        int low=nums[0];
        int high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        } 
        while(low<=high){
            int mid=low+(high-low)/2;
            int pi=countpartitions(nums,mid);
            if(pi>k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
        
    }
    
}
