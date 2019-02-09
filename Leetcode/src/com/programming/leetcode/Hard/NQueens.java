package com.programming.leetcode.Hard;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static class Position{
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Position[] positions =  new Position[n];
        solverUtil(0, n, res, positions);
        return res;
    }

    public void solverUtil(int crt_row, int n, List<List<String>> res, Position[] positions){
        if(crt_row==n){
            StringBuilder strBld = new StringBuilder();
            List<String> crt_result = new ArrayList<>();
            for(Position p : positions){
                for(int i = 0; i<n; i++){
                    if(p.col==i) strBld.append("Q");
                    else strBld.append(".");
                }
                crt_result.add(strBld.toString());
                strBld.setLength(0);
            }
            res.add(crt_result);
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
                solverUtil(crt_row+1, n, res, positions);
            }
        }
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        List<List<String>> res = obj.solveNQueens(4);
        for(List<String> r : res){
            System.out.println(r);
        }
    }

}
