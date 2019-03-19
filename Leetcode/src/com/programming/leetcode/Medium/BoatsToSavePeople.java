package com.programming.leetcode.Medium;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ptr1 = 0, ptr2 = people.length-1, res = 0;
        while (ptr1 <= ptr2){
            res++;
            if(ptr1 == ptr2) break;
            if(people[ptr1]+people[ptr2] <= limit) ptr1++;
            ptr2--;
        }
        return res;
    }

    public static void main(String[] args) {
        BoatsToSavePeople obj = new BoatsToSavePeople();
        System.out.println(obj.numRescueBoats(new int[]{3,1,2,2,3},5));
    }

}
