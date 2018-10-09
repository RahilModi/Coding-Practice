package com.programming.leetcode.Easy;

public class ShortestDistanceToChar {

    public int[] shortestToChar(String S, char C) {

        int n = S.length();
        int[] arr = new int[S.length()];
        int pos = -n;
        for(int i = 0; i < S.length() ; i++){
            if(S.charAt(i)==C) pos = i;
            else
                arr[i] = i-pos;
        }

        for(int i = S.length()-1; i >= 0 ; i--){
            if(S.charAt(i)==C) pos = i;
            else
                arr[i] = Math.min(arr[i], Math.abs(i-pos));
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] output = new ShortestDistanceToChar().shortestToChar("loveleetcode",'e');
        for(int o : output) System.out.print(o+" ");
    }
}
