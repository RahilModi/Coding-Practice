package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        Integer ans = Integer.MIN_VALUE;
        int[][] answer = new int[matrix.length][matrix[0].length];

        boolean[] visited = new boolean[matrix.length*matrix[0].length];
        Set<String> processing = new HashSet<>();
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                ans = Math.max(longestIncreasingPathDepthFirstSearch(i, j, null, visited, matrix, answer, processing), ans);
            }
        }
        return ans;
    }

    private int longestIncreasingPathDepthFirstSearch(int row, int col, Integer prevValue, boolean [] visited, int[][] matrix, int[][] answer, Set<String> processing){
        int ans = 0;
        if(row >= matrix.length || col >= matrix[row].length || row < 0 || col < 0 || (prevValue != null && matrix[row][col] <= prevValue)){
            return ans;
        }
        if(!visited[(row*matrix[row].length) + col] && !processing.contains(row+","+col)) {
            int crtValue = matrix[row][col];
            processing.add(row+","+col);
            ans = Math.max(longestIncreasingPathDepthFirstSearch(row++, col, crtValue, visited, matrix, answer, processing), ans);
            ans = Math.max(longestIncreasingPathDepthFirstSearch(row, col++, crtValue, visited, matrix, answer, processing), ans);
            ans = Math.max(longestIncreasingPathDepthFirstSearch(row--, col, crtValue, visited, matrix, answer, processing), ans);
            ans = Math.max(longestIncreasingPathDepthFirstSearch(row, col--, crtValue, visited, matrix, answer, processing), ans);

            visited[(row*matrix[row].length) + col] = true;
            answer[row][col] = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    }
}
