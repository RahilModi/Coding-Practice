package com.programming.geeksforgeeks.DynamicProgramming;

//https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
public class FloorTilesProblem {


    /*
             |  1, 1 < = n < m
            count(n) = |  2, n = m
            | count(n-1) + count(n-m), m < n
     */
    public int countWays(int n, int m){

        int[] count = new int[n+1];
        count[0] = 0;

        for(int i = 1; i<= n; i++){
            if(i > m){
                count[i] = count[i-1]+count[i-m];
            }
            else if(i < m){
                count[i] = 1;
            }else{
                count[i] = 2;
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        FloorTilesProblem obj = new FloorTilesProblem();
        System.out.println(obj.countWays(7,4));
    }

}
