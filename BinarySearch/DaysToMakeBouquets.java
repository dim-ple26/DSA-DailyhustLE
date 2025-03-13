package BinarySearch;

public class DaysToMakeBouquets {

    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0, nob = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) { 
                    nob++;
                    count = 0; 
                    if (nob >= m) return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1; 
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            mini = Math.min(mini, bloom);
            maxi = Math.max(maxi, bloom);
        }

        int low = mini, high = maxi;
        while (low < high) { 
            int mid = low + (high - low) / 2; 
            if (possible(bloomDay, mid, m, k)) {
                high = mid; 
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
}
