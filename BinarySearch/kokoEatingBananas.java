package BinarySearch;

public class kokoEatingBananas {

    public static int max(int[] piles){
        int maxi=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    public int cal(int[] piles,int hr){
        int t=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            t+=Math.ceil((double)(piles[i])/(double)(hr));
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int total=cal(piles,mid);
            if(total<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    
}
