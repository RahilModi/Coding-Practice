package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {

    public static int getMax(int[] arr, int size){
        int crt_max = 0;
        for(int  i = 1; i < size; i++){
            if(arr[i] > arr[crt_max]){
                crt_max = i;
            }
        }
        return crt_max;
    }

    public static void flip(int[] input, int index){
        int temp, start = 0;
        while(start < index){
            temp = input[start];
            input[start] = input[index];
            input[index]=temp;
            start++;
            index--;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for(int i = A.length ; i > 1; i--){
            int crt_max = getMax(A, i);
            if(crt_max != i - 1){
                flip(A,crt_max);
                System.out.println(Arrays.toString(A));
                flip(A, i-1);
                res.add(crt_max+1);
                res.add(i);
                System.out.println(Arrays.toString(A));
            }
        }
        System.out.println(Arrays.toString(A));
        return res;
    }



    public static void main(String[] args) {
        PancakeSorting pancakeSorting = new PancakeSorting();
        System.out.println(pancakeSorting.pancakeSort(new int[]{1,2,4,3}));
    }
}
