package com.programming.leetcode.Hard;

public class NQueensII {

    static class Position{
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    Integer num_pos_solutions = 0;
    public int totalNQueens(int n) {
        Position[] positions =  new Position[n];
        solverUtil(0, n, positions);
        return num_pos_solutions;
    }

    public void solverUtil(int crt_row, int n, Position[] positions){
        if(crt_row==n){
            num_pos_solutions++;
        }

        for(int i = 0; i < n ; i++){
            boolean bFoundPos = true;
            for(int j = 0; j < crt_row; j++){
                if(positions[j].col == i || positions[j].col-positions[j].row == i-crt_row|| positions[j].col+positions[j].row == i+crt_row){
                    bFoundPos = false;
                    break;
                }
            }
            if(bFoundPos){
                positions[crt_row] = new Position(crt_row, i);
                solverUtil(crt_row+1, n, positions);
            }
        }
    }

    //We can use backtracking to ....solve this problem...
    int count = 0;
    public int totalNQueensV1(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }

    public static void main(String[] args) {
        NQueensII obj = new NQueensII();
        System.out.println(obj.totalNQueens(4));
    }
}
