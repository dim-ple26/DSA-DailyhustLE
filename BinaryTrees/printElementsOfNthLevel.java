import java.util.LinkedList;
import java.util.Queue;

public class printElementsOfNthLevel {



    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
          Node temp =  q.peek();
          if(temp.left!=null) q.add(temp.left);
          if(temp.right!=null) q.add(temp.right);
          System.out.print(temp.val+" ");
          q.remove();
        }
        
    }

    public static void nlevel(Node root,int n){
        if(root==null) return;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
            nlevel(root.left,n-1);
            nlevel(root.right,n-1);
        
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a =new  Node(2);
        Node b =new  Node(3);
        root.left=a;
        root.right=b;

        Node c  = new Node(4);
        Node d = new Node(5);
        //root.val = 10;
        a.left=c;
        a.right=d;
        Node e = new Node(8);
        Node f = new Node(9);
        b.left =e;
        b.right=f;
       //preorder(root);
       //nlevel(root, 2);
       bfs(root);
    }
    



    
    
}
