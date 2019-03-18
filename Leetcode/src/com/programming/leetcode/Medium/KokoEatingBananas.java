package com.programming.leetcode.Medium;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 1000000000;
        while (left < right){
            int mid = left + (right - left)/2;
            int need = 0;
            for(int p : piles ){
                need += p / mid;
                if(p % mid != 0){
                    need++;
                }
            }
            if(need > H) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

}
