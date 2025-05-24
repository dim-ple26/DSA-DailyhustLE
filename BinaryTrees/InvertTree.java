import javax.swing.tree.TreeNode;



    class Solution {
    public TreeNode invertTree(TreeNode root) {

        if(root==null) return root;
        
        TreeNode l=root.left;
        TreeNode r = root.right;
        
        root.left=invertTree(r);
        root.right=invertTree(l);

        return root;











        
    }
}
    

