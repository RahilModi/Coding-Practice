package com.programming.GeeksForGeeks.coursera_algoritms.DisjointSets;

import java.util.Arrays;

public class ValidationUtil {

    static boolean isValidInput(int index, int array_length){
        if (index < 0 || index >= array_length) {
            throw new IllegalArgumentException("index: " + index + " is not between 0 and " + (array_length-1));
        }
        return true;
    }

    static void printInputArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
