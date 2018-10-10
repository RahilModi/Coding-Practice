package com.programming.leetcode.Easy;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {

        int[][] res = new int[M.length][M[0].length];
        for(int i = 0 ; i < M.length ; i++){
            for(int j = 0 ; j < M[i].length; j++){
                res[i][j] = sumOfNeighbors(M, i, j);
            }
        }

        return res;

    }

    private int sumOfNeighbors(int[][] input, int row, int col){
        int sum = 0;
        int x,y;
        int count = 0;
        for(x = row-1; x <= row+1; x++){
            for(y = col -1;y <= col+1; y++){
                if(x < 0 || x >= input.length || y < 0 || y >= input.length) continue;
                else{
                    sum += input[x][y];
                    count++;
                }
            }
        }

        return count == 0 ? sum : sum/count;

    }

    public static void main(String[] args) {
        new ImageSmoother().imageSmoother(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}});
    }

}
