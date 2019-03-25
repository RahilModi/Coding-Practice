package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }else{
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[] dirs = { 0, 1, 0, -1, 0};
        while (!queue.isEmpty()){
            int crt[] = queue.poll();
            for(int k = 0 ; k < 4; k++){
                int r = crt[0] + dirs[k];
                int c = crt[1] + dirs[k+1];
                if(r >= 0 && c >= 0 && r < n && c < matrix[r].length && matrix[r][c] > (matrix[crt[0]][crt[1]]+1)){
                    matrix[r][c] = Math.min(matrix[r][c], matrix[crt[0]][crt[1]] + 1);
                    queue.offer(new int[]{r,c});
                }
            }
        }
        return matrix;
    }

    //https://leetcode.com/problems/01-matrix/discuss/101051/Simple-Java-solution-beat-99-(use-DP)

    public int[][] updateMatrixV1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int[][] dis = new int[matrix.length][matrix[0].length];
        int range = matrix.length * matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                } else {
                    int upCell = (i > 0) ? dis[i - 1][j] : range;
                    int leftCell = (j > 0) ? dis[i][j - 1] : range;
                    dis[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                } else {
                    int downCell = (i < matrix.length - 1) ? dis[i + 1][j] : range;
                    int rightCell = (j < matrix[0].length - 1) ? dis[i][j + 1] : range;
                    dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,0,0},{0,0,1},{1,1,1}};
        Matrix01 obj = new Matrix01();
        Arrays.stream(obj.updateMatrix(matrix)).forEach( row -> System.out.println(Arrays.toString(row)));
    }
}
