package com.programming.leetcode.Medium;

public class AndroidUnlockPattern {

    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[7][3] = skip[3][7] = skip[4][6] =skip[6][4] = skip[2][8]=skip[8][2] = 5;
        boolean [] visited = new boolean[10];
        int res = 0;
        while (m <= n){
            res += dfs(1, m-1, visited, skip) * 4;
            res += dfs(2, m-1, visited, skip) * 4;
            res += dfs(5, m-1, visited, skip);
            m++;
        }
        return res;
    }

    public int dfs(int crt, int remain, boolean[] visited,int[][] skip){
        if(remain < 0) return 0;
        if(remain == 0) {
            return 1;
        }
        visited[crt] = true;
        int res = 0;
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && (skip[crt][i] == 0 || (visited[skip[crt][i]]))){
                res += dfs(i, remain-1,visited,skip);
            }
        }
        visited[crt] = false;
        return res;
    }

    public static void main(String[] args) {
        AndroidUnlockPattern obj = new AndroidUnlockPattern();
        System.out.println(obj.numberOfPatterns(1,2));
    }

}
