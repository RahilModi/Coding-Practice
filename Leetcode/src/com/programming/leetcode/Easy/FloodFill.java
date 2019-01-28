package com.programming.leetcode.Easy;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length == 0) return new int[0][];
        int srcColor = image[sr][sc];
        dfs(sr,sc, srcColor, newColor, image );
        return image;
    }

    private void dfs(int row, int col, int srcColor, int newColor, int[][] image){
        if(row < 0 || row > image.length-1 || col < 0 || col > image[0].length-1 || image[row][col] == newColor || image[row][col] != srcColor) return;
        image[row][col] = newColor;
        dfs(row-1,col,srcColor,newColor,image);
        dfs(row,col-1,srcColor,newColor,image);
        dfs(row+1,col,srcColor,newColor,image);
        dfs(row,col+1,srcColor,newColor,image);
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,0}};
        obj.floodFill(image,1,1,2);
        for(int[] row: image){
            System.out.println(Arrays.toString(row));
        }
    }
}
