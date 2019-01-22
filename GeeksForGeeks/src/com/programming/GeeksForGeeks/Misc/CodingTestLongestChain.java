package com.programming.GeeksForGeeks.Misc;

public class CodingTestLongestChain {

    public int longestChain(int[] input){
        int[] distance = new int[input.length];
        int max_distance = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++){
            if(i != input[i]) {
                int crt_distance = dfs_helper(input, i, i, distance, 1);
                max_distance = Math.max(max_distance, crt_distance);
            }
        }
        return max_distance;
    }

    public int dfs_helper(int[] input, int crt_index, int looking_for, int[] distance_array, int final_distance){
        if(input[crt_index] == looking_for){
            distance_array[crt_index] = final_distance;
            return distance_array[crt_index];
        }
        if(distance_array[crt_index] == 0){
            distance_array[crt_index] = dfs_helper(input, input[crt_index], looking_for, distance_array, final_distance+1 );
        }
        return distance_array[crt_index];
    }

    public static void main(String[] args) {
        System.out.println(new CodingTestLongestChain().longestChain(new int[]{5,4,0,3,1,6,2}));
    }
}
