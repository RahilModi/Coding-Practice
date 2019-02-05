package com.programming.leetcode.Medium;

public class ScoreAfterFlippingMatrix {

    //Greedy O(R*C)
    public int matrixScore(int[][] A) {
        int numRows = A.length, numCols = A[0].length;
        int ans = 0;
        for(int col = 0; col < numCols; col++){
            int crt_col_sum = 0;
            for(int row = 0; row<numRows; row++){
                crt_col_sum += A[row][col] ^ A[row][0];
            }
            ans += Math.max(crt_col_sum, numRows-crt_col_sum)*(1 << (numCols-col-1));
        }
        return ans;
    }

    //Normal
    public int matrixScoreV1(int[][] A) {
        int num_rows = A.length, num_cols = A[0].length;
        //first try to make begining of the row with 1.
        for(int row = 0; row < num_rows;row++){
            if(A[row][0] == 0){
                for(int col = 0; col < num_cols ;col++){
                    A[row][col] ^= A[row][0];
                }
            }
        }

        //Now if number of zeros are more in the column so flip the values of the column..
        for(int col = 0; col < num_cols; col++){
            int numZero = 0;
            int numOne = 0;
            for(int i = 0; i < num_rows;i++){
                if(A[i][col] == 0) numZero++;
                else numOne++;
            }
            if(numZero > numOne){
                for(int i = 0; i < num_rows; i++){
                    A[i][col] = (A[i][col]==0)?1:0;
                }
            }
        }

        int score = 0;
        for(int row = 0; row < A.length;row++){
            StringBuilder rowStr = new StringBuilder();
            for(int col = 0; col < A[0].length;col++){
                rowStr.append(A[row][col]);
            }
            score += Integer.parseInt(rowStr.toString(),2);
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix obj = new ScoreAfterFlippingMatrix();
        int[][] matrix = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(obj.matrixScore(matrix));
    }

}
