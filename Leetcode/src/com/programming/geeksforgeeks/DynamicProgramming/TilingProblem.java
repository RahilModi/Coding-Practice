package com.programming.geeksforgeeks.DynamicProgramming;

//https://www.geeksforgeeks.org/tiling-problem/
public class TilingProblem {

    //in 2*n board how many ways you can file 2*1  ==> we can use it using nth Fibonacci..or use formula count(n-1) + count(n-2)
    /*
        Input n = 3
        Output: 3
        Explanation:
        We need 3 tiles to tile the board of size  2 x 3.
        We can tile the board using following ways
        1) Place all 3 tiles vertically.
        2) Place first tile vertically and remaining 2 tiles horizontally.
        3) Place first 2 tiles horizontally and remaining tiles vertically
     */
    public int numWays(int n){
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        for(int i=3; i <=n ; i++){
            count[i] = count[i-1]+count[i-2];
        }
        return count[n];
    }

    public static void main(String[] args) {

    }
}
