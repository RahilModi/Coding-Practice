package com.programming.leetcode.Hard;

public class MinimizeMaxDistanceToGasStation {
    /*
    On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

    Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

    Return the smallest possible value of D.
    INPUT: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
    OUTPUT: 0.500000
     */
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0, right = stations[stations.length-1]-stations[0], mid;
        int count = 0;
        while (left + 1e-6 < right){
            mid = left+(right-left)/2;
            count = 0;
            for(int i = 0; i < stations.length-1;i++){
                count += Math.ceil((stations[i+1]-stations[i])/mid)-1;
            }
            if(count > K) left = mid;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation obj = new MinimizeMaxDistanceToGasStation();
        System.out.println(obj.minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10},9));
    }
}
