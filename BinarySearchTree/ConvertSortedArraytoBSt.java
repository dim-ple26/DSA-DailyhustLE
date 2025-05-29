public class ConvertSortedArraytoBSt {
    
}
class Solution {
    public TreeNode helper(int[] nums, int low, int high){
        if(low>high) return null;
        int mid=low+(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=helper(nums,low,mid-1);
        root.right=helper(nums,mid+1,high);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;
        return helper(nums,0,n-1);
        
    }
}