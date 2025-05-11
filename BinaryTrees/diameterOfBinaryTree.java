public class diameterOfBinaryTree {


        public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }



  public int height(Node root){
     if(root==null || root.left==null && root.right==null) return 0;
     return 1+Math.max(height(root.left),height(root.right));


  }

  public int diameter(Node root){
        if(root==null || root.left==null || root.right==null) return 0;
        int leftans = diameter(root.left);
        int rightans = diameter(root.right);

        int mid = height(root.left)+height(root.right);
        if(root.left!=null ) mid++;
        if(root.right!=null) mid++;

        return Math.max(leftans,Math.max(rightans,mid));

  }

    
}
