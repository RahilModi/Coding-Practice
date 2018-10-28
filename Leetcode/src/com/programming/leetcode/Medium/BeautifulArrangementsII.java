package com.programming.leetcode.Medium;

public class BeautifulArrangementsII {

    //Alternate Approach is create permutations of the n-sized array and

    public int[] constructArray(int n, int k) {
        int res [] = new int[n];
        for(int i=0, l = 1, j = n; i < n ; i++){
            res[i] = k > 1 ? ( k-- % 2 != 0 ? l++ : j--) : l++;
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i : new BeautifulArrangementsII().constructArray(9,3)){
            System.out.println(i);
        }

        for(int i : new BeautifulArrangementsII().constructArray(3,1)){
            System.out.println(i);
        }

        for(int i : new BeautifulArrangementsII().constructArray(3,2)){
            System.out.println(i);
        }
    }
}
