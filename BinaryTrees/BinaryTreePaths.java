import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BinaryTreePaths {

    class Solution {

    public void helper(TreeNode root, List<String> arr,String s){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s+=root.val;
            arr.add(s);
            return;
        }

        helper(root.left,arr,s+root.val+"->");
        helper(root.right,arr,s+root.val+"->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();
        helper(root,arr,"");

        return arr;
        
    }
}
    
}
