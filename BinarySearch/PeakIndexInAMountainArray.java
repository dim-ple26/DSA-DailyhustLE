package BinarySearch;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=(low)+(high-low)/2;
            if(arr[mid]>arr[mid+1]){
                // u are in the dec part of arr
                // this may be the ans but look at left thats why end!=mid-1
                high=mid;
            }else{
                low=mid+1;
                // asc part of the array
            }
            // int he end low==high and pointing to the largest no. bcoz of the above checks
            // they always try to find max element in the two above checks
            //  hence they are pointing to one element which is the peak index
        }
        return low;

    }
    
}
