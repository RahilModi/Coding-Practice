package com.programming.leetcode.Medium;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        int max_sq_len = 0;
        for(int i = 0; i < num_rows; i++){
            for(int j = 0; j < num_cols; j++){
                if(matrix[i][j]=='1'){
                    int crt_sq_len= 1;
                    boolean flag = true;
                    while (crt_sq_len+i < num_rows && crt_sq_len+j<num_cols && flag) {
                        for (int k = j; k <= j + crt_sq_len; k++) {
                            if (matrix[i + crt_sq_len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= i + crt_sq_len && flag; k++) {
                            if (matrix[k][j + crt_sq_len] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            crt_sq_len++;
                        }
                    }

                    max_sq_len = Math.max(max_sq_len, crt_sq_len);
                }
            }
        }
        return max_sq_len * max_sq_len;
    }

    //DP
    public int maximalSquareV1(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }

}
