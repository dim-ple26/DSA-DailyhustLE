public class kthsmallestelementinBST {
    
}
class Solution {

    
    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr=root;
        int count=0;

        while(curr!=null){
            if(curr.left==null){
                count++;
                if(count==k) return curr.val;
                curr=curr.right;
            }
            else{
                TreeNode pre = curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre=pre.right;
                }

                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;

                }else{
                    pre.right=null;
                    count++;
                    if(count==k) return curr.val;
                    curr=curr.right;
                }
            }
        }

        return -1;


        
    }
}