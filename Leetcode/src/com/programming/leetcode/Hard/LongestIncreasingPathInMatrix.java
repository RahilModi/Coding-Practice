package com.programming.leetcode.Hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        Integer ans = Integer.MIN_VALUE;
        int[][] answer = new int[matrix.length][matrix[0].length];

        boolean[] visited = new boolean[matrix.length*matrix[0].length];
        Set<String> processing = new HashSet<>();
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(answer[i][j]==0) {
                    ans = Math.max(longestIncreasingPathDepthFirstSearch(i, j, null, visited, matrix, answer, processing), ans);
                }else{
                    ans = Math.max(answer[i][j],ans);
                }
            }
        }
        return ans;
    }

    private int longestIncreasingPathDepthFirstSearch(int row, int col, Integer prevValue, boolean [] visited, int[][] matrix, int[][] answer, Set<String> processing){
        if(row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0 || (prevValue != null && matrix[row][col] <= prevValue)){
            return 0;
        }
        int len = 1;
        if(!visited[(row*matrix[row].length) + col] && !processing.contains(row+","+col)) {
            int crtValue = matrix[row][col];
            processing.add(row+","+col);
            len = Math.max(len, 1 + longestIncreasingPathDepthFirstSearch(row+1, col, crtValue, visited, matrix, answer, processing));
            len = Math.max(len, 1 + longestIncreasingPathDepthFirstSearch(row, col+1, crtValue, visited, matrix, answer, processing));
            len = Math.max(len, 1 + longestIncreasingPathDepthFirstSearch(row-1, col, crtValue, visited, matrix, answer, processing));
            len = Math.max(len, 1 + longestIncreasingPathDepthFirstSearch(row, col-1, crtValue, visited, matrix, answer, processing));
            processing.remove(row+","+col);
            visited[(row*matrix[row].length) + col] = true;
            answer[row][col] = len;
        }
        return answer[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    }
}
