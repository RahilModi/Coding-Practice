package com.programming.leetcode.Hard;

public class SuperEggDropping {

    //O(KN^2) DP solution, where dp[k][n] = min(1 + max(dp[k - 1][i - 1], dp[k][n - i])) i = 1...n
    public int superEggDrop(int K, int N) {

        int[][] dp = new int[K+1][N+1];
        for(int i = 1; i <= K; i++){
            for(int j = 1; j <= N; j++){
                if(i == 1) dp[i][j] = j;
                else if(i > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= j; k++) {
                        int c = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                        dp[i][j] = Math.min(c, dp[i][j]);
                    }
                }
            }
        }
        return dp[K][N];
    }

    public int superEggDropRecursive(int K, int N){
        if(K==1) return N;
        if(N == 0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=N;i++){
            int val = 1 + Math.max(superEggDropRecursive(K-1, i-1), superEggDropRecursive(K,N-i));
            min = Math.min(val, min);
        }
        return min;
    }

    //https://leetcode.com/problems/super-egg-drop/discuss/158974/C%2B%2BJavaPython-2D-and-1D-DP-O(KlogN)
    public int superEggDropV1(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    //super egg drop one dimensional solution..
    public int superEggDropV2(int K, int N) {
        int dp[] = new int[K + 1], m;
        for (m = 0; dp[K] < N; ++m)
            for (int k = K; k > 0; --k)
                dp[k] += dp[k - 1] + 1;
        return m;
    }

    public static void main(String[] args) {
        SuperEggDropping obj = new SuperEggDropping();
        System.out.println(obj.superEggDrop(3,10));
        System.out.println(obj.superEggDropRecursive(3,14));
        System.out.println(obj.superEggDropV1(3,14));
    }

}
