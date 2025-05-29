public class ConvertSortedlisttoBST {
    
}
class Solution {
    public TreeNode helper(int[] nums, int low, int high){
        if(low>high) return null;
        int mid=low+(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=helper(nums, low,mid-1);
        root.right=helper(nums,mid+1,high);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {


     ListNode temp=head;
     int n =0;
     while(temp!=null){
        n++;
        temp=temp.next;
     }        

     int nums[] = new int[n];
     int i=0;
     temp=head;
     while(temp!=null){
        nums[i++]=temp.val;
        temp=temp.next;

     }

     return helper(nums,0,n-1);

        
    }
}