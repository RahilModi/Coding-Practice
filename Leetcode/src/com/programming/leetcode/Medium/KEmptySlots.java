package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.TreeSet;

public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length == 0 || k < 0) return -1;
        int[] days = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i + 1;
        }
        System.out.println(Arrays.toString(days));
        int left  =0, right = left+k+1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i==right) res = Math.min(res, Math.max(days[left],days[right]));
                left = i;
                right = left + k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int kEmptySlotsV1(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0 || k < 1) {
            return -1;
        }

        int day = 0;
        TreeSet<Integer> set = new TreeSet<>();

        for (int flower : flowers) {
            set.add(flower);

            Integer low = set.lower(flower);
            Integer high = set.higher(flower);
            ++day;
            if ((low != null && low == flower - k - 1)
                    || high != null && high == flower + k + 1) {
                return day;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KEmptySlots obj = new KEmptySlots();
        System.out.println(obj.kEmptySlotsV1(new int[]{6,5,8,9,7,1,10,2,3,4},
                2));
        System.out.println(obj.kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4},
        2));
    }

}
