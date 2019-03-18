package com.programming.leetcode.Medium;

public class CapacityToShipPackagesInDDays {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for(int w : weights){
            left = Math.max(w, left);
            right += w;
        }

        while (left < right){
            int mid = left + (right-left)/2;
            int need = 1, crt = 0;
            for(int w : weights){
                if(crt + w > mid){
                    need++;
                    crt = 0;
                }
                crt += w;
            }
            if(need > D) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesInDDays obj = new CapacityToShipPackagesInDDays();
        System.out.println(obj.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
