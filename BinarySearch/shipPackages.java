package BinarySearch;

public class shipPackages {

    public int dayss(int[] weights,int capacity){
        int days=1,load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>capacity){
                days+=1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi=0;
        int sum=0;
        //sum
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        //max
        for(int i=0;i<weights.length;i++){
            maxi=Math.max(weights[i],maxi);
        }

        int low=maxi;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int numdays=dayss(weights,mid);
            if(numdays<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    
}
