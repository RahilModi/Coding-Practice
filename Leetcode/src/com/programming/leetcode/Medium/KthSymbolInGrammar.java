package com.programming.leetcode.Medium;

public class KthSymbolInGrammar {

    //Memory Limit Exceeds..
    public int kthGrammar(int N, int K) {
        return helper(1, "0", N, K);
    }
    private int helper(int crtRow, String prev, int targetRow, int kthSymbol){
        if(crtRow == targetRow)
            return prev.charAt(kthSymbol-1)-'0';
        StringBuilder sb = new StringBuilder();
        for(char c : prev.toCharArray()){
            if(c == '0') sb.append("01");
            else sb.append("10");
        }
        return helper(crtRow+1, sb.toString(), targetRow, kthSymbol);
    }

    //https://leetcode.com/problems/k-th-symbol-in-grammar/discuss/113705/JAVA-one-line
    public int kthGrammarV1(int N, int K) {
        return Integer.bitCount(K-1)&1;
    }

    private final int[][] decodeMap = {{1,0},{0,1}};
    public int kthGrammarV2(int N, int K) {
        return helper(N,K);
    }

    private int helper(int N, int K){
        if(N == 1) return 0;
        int crt = helper(N-1, (K+1)/2);
        return decodeMap[crt][K&1];
    }

    public int kthGrammarV3(int N, int K) {
        int left = 1 << N;
        int val = 0;
        for(int i = 0; i < N; i++) {
            if (K > left / 2) {   // go right leaf
                val = 1 - val;
                K -= (left / 2);
            }
            left >>= 1;
        }

        return val;
    }

    public static void main(String[] args) {
        KthSymbolInGrammar obj = new KthSymbolInGrammar();
        System.out.println(obj.kthGrammar(1,1));
        System.out.println(obj.kthGrammar(2,1));
        System.out.println(obj.kthGrammar(4,5));

    }

}
