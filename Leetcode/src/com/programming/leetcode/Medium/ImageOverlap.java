package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {

        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length ; j++){
                if(A[i][j] == 1) listA.add(new int[]{i,j});
                if(B[i][j] == 1) listB.add(new int[]{i,j});
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for(int[] la : listA){
            for(int[] lb : listB){
                String str = (la[0]-lb[0]) + " : " + (la[1]-lb[1]);
                map.put(str, map.getOrDefault(str, 0)+1);
            }
        }

        int max = 0;
        for(int i : map.values()){
            max = Math.max(i,max);
        }

        return max;

    }

    //O(N^4)
    public int largestOverlapV1(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }

    public static void main(String[] args) {
        ImageOverlap obj = new ImageOverlap();
        System.out.println(obj.largestOverlap(new int[][]{{1,1,0},{0,1,1},{0,1,0}},new int[][]{{0,0,0},{0,1,1},{0,0,1}}));
        System.out.println(obj.largestOverlapV1(new int[][]{{1,1,0},{0,1,1},{0,1,0}},new int[][]{{0,0,0},{0,1,1},{0,0,1}}));
    }

}
