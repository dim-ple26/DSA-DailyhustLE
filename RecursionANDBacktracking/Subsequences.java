package RecursionANDBacktracking;
public class Subsequences {
   

   public static void getSubsequences(int i, String s,String f){
      if(i==s.length()){
        System.out.print(f+" ");
        return;
      }

      getSubsequences(i+1, s, f+s.charAt(i));
      getSubsequences(i+1, s, f);

   }
   public static void main(String[] args) {
    String s ="abc";
    String f="";
    System.out.println("all possible subsequences of given string are:");
    getSubsequences(0, s, f);
    
   }
}