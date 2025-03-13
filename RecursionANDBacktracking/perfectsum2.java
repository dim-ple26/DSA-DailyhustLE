package RecursionANDBacktracking;

public class perfectsum2 {

    public static int f(int ind,int s,int sum,int nums[],int n){
        if(ind==n){
            if(s==sum){
                return 1;
            }
            else return 0;
        }

        s+=nums[ind];
        int l=f(ind+1,s,sum,nums,n);
        s-=nums[ind];
        int r=f(ind+1,s,sum,nums,n);

        return l+r;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        int sum=10;
        int n=nums.length;
        System.out.println(f(0,0,sum,nums,n));
    }
    
}
