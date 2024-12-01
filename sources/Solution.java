import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0,1,0};
        System.out.println(s.peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] peak) {
        int mid = peak.length/2;
        if(peak.length == 1){
            return 0;
        } else if(peak.length == 2){
            return peak[1] > peak[0] ? 1 : 0;
        } else if(peak[mid] < peak[mid-1]){
            int[] copys = Arrays.copyOfRange(peak, 0, mid);
            return peakIndexInMountainArray(copys);
        } else{
            int[] copyd = Arrays.copyOfRange(peak, mid, peak.length);
            return peakIndexInMountainArray(copyd) + mid;
        }

    }
}
