private static void deleteLeaf(Node root, int target){
    if(root==null) return;
    if(root.val>target){
        if(root.left==null) return;
        if(root.left.val==target) root.left=null;
        else delete(root.left,target);
    }

    else{
        if(root.right ==null) return;
        if(root.right.val==target) root.right=null;
        else delete(root.right,target);
    }
}




private static void deleteOne(Node root, int target){
    if(root==null) return;
    if(root.val>target){
        if(root.left==null) return;
        if(root.left.val==target) {
            Node l = root.left;
            if(l.left==null && l.right==null) root.left=null;
            else if(l.left==null || l.right==null){
                if(l.left!=null) root.right=l.left;
                else root.left =l.right;
            }
        }
        else delete(root.left,target);
    }

    else{
        if(root.right ==null) return;
        if(root.right.val==target) {
            Node r =root.right;
            if(r.left==null && r.right==null) root.right=null;
            else if(r.left==null || r.right==null){
                if(r.left!=null) root.right=r.left;
                else root.right=r.right;
            }
        }
        else delete(root.right,target);
    }
}



class Solution {

    public static void delete(TreeNode root, int target){
    if(root==null) return;
    if(root.val>target){
        if(root.left==null) return;
        if(root.left.val==target) {
            TreeNode l = root.left;
            if(l.left==null && l.right==null) root.left=null;
            else if(l.left==null || l.right==null){
                if(l.left!=null) root.left=l.left;
                else root.left =l.right;
            }
            else{
                TreeNode curr=l;
                TreeNode pred=curr.left;
                while(pred.right!=null) pred=pred.right;
                delete(root,pred.val);
                pred.left=curr.left;
                pred.right=curr.right;
                root.left=pred;
            }
        }
        else delete(root.left,target);
    }

    else{
        if(root.right ==null) return;
        if(root.right.val==target) {
            TreeNode r =root.right;
            if(r.left==null && r.right==null) root.right=null;
            else if(r.left==null || r.right==null){
                if(r.left!=null) root.right=r.left;
                else root.right=r.right;
            }
            else{
                TreeNode curr=r;
                TreeNode pred=curr.left;
                while(pred.right!=null) pred=pred.right;
                delete(root,pred.val);
                pred.left=curr.left;
                pred.right=curr.right;
                root.right=pred;
            }

        }
        else delete(root.right,target);
    }
}
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode temp= new TreeNode(Integer.MAX_VALUE);
        temp.left=root;
        delete(temp,key);

        return temp.left;


        
    }
}