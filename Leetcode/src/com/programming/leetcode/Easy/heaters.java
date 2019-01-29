package com.programming.leetcode.Easy;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/discuss/95886/Short-and-Clean-Java-Binary-Search-Solution
public class heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0){
                index = - (index +1);
            }
            int dist1 = index-1 >= 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }

    public int findRadiusTwoPointers(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int res = Integer.MIN_VALUE;
        int i = 0, j = 0;
        for(int house : houses){
            while(j < heaters.length-1){
                if(Math.abs(heaters[j+1]-house) < Math.abs(heaters[j]-house) ){
                    j++;
                }else break;
            }
            res = Math.max(res, Math.abs(heaters[j]-house));
        }

        return res;
    }

    public static void main(String[] args) {
        heaters h = new heaters();
        System.out.println(h.findRadius(new int[]{1,2,3,4},new int[]{1,4}));
        System.out.println(h.findRadiusTwoPointers(new int[]{1,2,3,4},new int[]{1,4}));
    }

}
