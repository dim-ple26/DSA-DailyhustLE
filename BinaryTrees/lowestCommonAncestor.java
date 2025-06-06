public class lowestCommonAncestor {

    class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==p || root==q) return root;
        if(p==q) return p;

        boolean leftp = contains(root.left,p);
        boolean rightq = contains(root.right,q);

        if(leftp && rightq) return root;
        if(leftp && !rightq) return lowestCommonAncestor(root.left,p,q);
        if(!leftp && rightq) return lowestCommonAncestor(root.right,p,q);
        if(!leftp && !rightq) return root;

        return root;
        
    }

    public boolean contains(TreeNode root, TreeNode node){
        if(root==null) return false;
        if(root==node) return true;
        return contains(root.left,node) || contains(root.right,node);
    }
}
    
}
