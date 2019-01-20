package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

public class SurroundedRegions {

    private static void printMatrix(char[][] matrix){
        for(char[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------");
    }

    public void solve(char[][] board) {

        printMatrix(board);
        if(board ==null ||board.length < 2 || board[0].length < 2) return;
        int num_rows = board.length;
        int num_cols = board[0].length;

        for(int i =0 ; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if ((i == 0 || i == num_rows - 1 || j == 0 || j == num_cols - 1) && board[i][j] == 'O') {
                    dfs_helper(board, i, j, num_rows, num_cols);
                    //bfs_helper(board,i,j,num_rows,num_cols);
                }
            }
        }

        printMatrix(board);
        for(int i =0 ; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '1') board[i][j] = 'O';
            }
        }

        printMatrix(board);

    }

    int [][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs_helper(char[][] grid, int row, int col, int num_rows, int num_cols){
        grid[row][col] = '1';
        for(int[] dir : directions){
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            if(new_row>=0 && new_row < num_rows && new_col >= 0 && new_col < num_cols && grid[new_row][new_col]=='O'){
                dfs_helper(grid,new_row,new_col,num_rows,num_cols);
            }
        }
    }

    public void bfs_helper(char[][] grid, int row, int col, int num_rows, int num_cols){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '1';
        while(!queue.isEmpty()) {
            int[] crt_pos = queue.poll();
            for (int[] dir : directions) {
                int new_row = crt_pos[0] + dir[0];
                int new_col = crt_pos[1] + dir[1];
                if (new_row >= 0 && new_row < num_rows && new_col >= 0 && new_col < num_cols && grid[new_row][new_col] == 'O') {
                    grid[new_row][new_col] = '1';
                    queue.offer(new int[]{new_row, new_col});
                }
            }
        }
    }


    public void solve_using_union_find(char[][] board) {

        printMatrix(board);
        if(board ==null ||board.length < 2 || board[0].length < 2) return;

        int num_rows = board.length;
        int num_cols = board[0].length;

        UF uf = new UF(num_rows * num_cols + 1);


        for(int i =0 ; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if ((i == 0 || i == num_rows - 1 || j == 0 || j == num_cols - 1) && board[i][j] == 'O') {
                    uf.union(i*num_cols+j, num_rows*num_cols);
                }else if(board[i][j]=='O'){

                    for(int[] dir: directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (board[x][y] == 'O') {
                            uf.union(i * num_cols + j, x * num_cols + y);
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(uf.parents));

        printMatrix(board);
        for(int i =0 ; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {
                if(!uf.connected(i*num_cols+j, num_cols * num_rows)){
                    board[i][j] = 'X';
                }
            }
        }

        printMatrix(board);

    }


    class UF{
        int[] parents;
        int[] rank;
        int count;

        public UF(int N) {
            this.count = N;
            this.parents = IntStream.range(0,N).toArray();
            this.rank = IntStream.generate(()->0).limit(N).toArray();
        }

        public int find(int p){
            while(p != parents[p]){
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public boolean connected(int p, int q){
            System.out.println(p +"---"+q);
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (rank[i] < rank[j]) parents[i] = j;
            else if (rank[i] > rank[j]) parents[j] = i;
            else {
                parents[j] = i;
                rank[i]++;
            }
            count--;
        }
    }

    public static void main(String[] args) {

        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(new char[][]{{'X', 'X','X','X'},{'X', 'O','O','X'},{'X', 'X','O','X'},{'X', 'O','X','X'}});

        obj.solve_using_union_find(new char[][]{{'X', 'X','X','X'},{'X', 'O','O','X'},{'X', 'X','O','X'},{'X', 'O','O','X'}});

    }
}
