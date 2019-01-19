package com.programming.leetcode.Medium;


//Implementing using Union Find..
public class NumberOfIslands {

    int[][] distances = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //only down and left also works because we are starting from 0,0

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distances) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            int crt_pos = i * cols + j;
                            int next_pos = x * cols + y;
                            uf.union(crt_pos, next_pos);
                        }
                    }
                }
            }
        }
        return uf.count;

    }

    class UnionFind{
        int[] parent;
        int m,n,count = 0;

        public UnionFind(char[][] input_grid) {
            m = input_grid.length;
            n = input_grid[0].length;

            parent = new int[m*n];

            for(int i = 0; i<m; i++){
                for(int j = 0 ; j < n; j++){
                    if(input_grid[i][j] == '1'){
                        int pos = i *n + j;
                        parent[pos]=pos;
                        count++;
                    }
                }
            }
        }

        public void union(int node1, int node2){
            int parent_of_node1 = find(node1);
            int parent_of_node2 = find(node2);
            if(parent_of_node1 != parent_of_node2){
                parent[parent_of_node1] = parent_of_node2;
                count--;
            }
        }

        private int find(int node1){
            if(node1 == parent[node1]){
                return node1;
            }
            parent[node1] = find(parent[node1]);
            return parent[node1];
        }
    }

    public int numIslandsDFS_WithShrinking(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}

