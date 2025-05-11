// By Two pointers

class Solution {
    public boolean isPalindrome(String s) {

        int left =0,right =s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}






// BY recursion
class PalindromeCheck {
    public boolean isPalindrome(int left,int right,String s) {
        //int left = 0, right = s.length() - 1;

       if(left>=right){
        return true;
       }
       if(s.charAt(left)!=s.charAt(right)){
        return false;
       }
       return isPalindrome(left+1,right-1,s);
    }
}
