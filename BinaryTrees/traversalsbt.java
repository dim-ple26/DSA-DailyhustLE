public class traversalsbt {



public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root){
        if(root==null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(2);
        Node a =new  Node(4);
        Node b =new  Node(10);
        root.left=a;
        root.right=b;

        Node c  = new Node(6);
        Node d = new Node(7);
        //root.val = 10;
        a.left=c;
        a.right=d;
        Node e = new Node(8);
        b.right=e;
       preorder(root);
       
    }
    
}

