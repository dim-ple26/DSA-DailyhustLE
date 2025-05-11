
import java.util.*;
public class binary_tree_implement{

    public static class Node{
        int val;
        Node left,right;

        public Node(int val){
            this.val=val;
            this.left = null;
            this.right=null;
        }

    }

    public static void display(Node root){
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node a =new  Node(4);
        Node b =new  Node(5);
        root.left=a;
        root.right=b;

        Node c  = new Node(6);
        Node d = new Node(7);
        //root.val = 10;
        System.out.println(root);
    }
    
}