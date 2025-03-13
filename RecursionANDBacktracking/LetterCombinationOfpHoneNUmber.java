package RecursionANDBacktracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfpHoneNUmber {

    private void solve(String digit, String output,int index,List<String> ans, String[] mapping){
        if(index>=digit.length()){
            ans.add(output);
            return;
        }

        int num=digit.charAt(index)-'0';
        String value = mapping[num];
        for(int i=0;i<value.length();i++){
            //output.add(value[i]);
            solve(digit,output+value.charAt(i),index+1,ans,mapping);
            //output.remove();
        }




    }
    public List<String> letterCombinations(String digits) {

        List<String> ans= new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String output="";
        int index=0;
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,output,index,ans,mapping);
        return ans;
        
    }
    
}
