package com.programming.leetcode.Easy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int pointerGreed = 0;
        int pointerS = 0;
        int count = 0;
        while (pointerGreed < g.length && pointerS < s.length){
            if(g[pointerGreed] <= s[pointerS]){
                pointerGreed++;
                pointerS++;
                count++;
            }else {
                pointerS++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(new AssignCookies().findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }


}
