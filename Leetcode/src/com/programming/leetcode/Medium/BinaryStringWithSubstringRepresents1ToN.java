package com.programming.leetcode.Medium;

public class BinaryStringWithSubstringRepresents1ToN {

    public boolean queryString(String S, int N) {
        for(int i = N; i > N/2; i--){
            if(!S.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }

    public boolean queryStringV1(String S, int N){
        boolean[] seen = new boolean[N+1];
        seen[0] = true;
        int totalNums = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i)=='0') continue;
            int num = 0;
            for(int j = i; j < S.length() && num <= N; j++){
                num = num << 1 + (S.charAt(i)-'0');
                if(num >= 1 && num <= N && !seen[num]){
                    seen[num] = true;
                    totalNums++;
                }
            }
        }
        return totalNums == N;
    }

    public static void main(String[] args) {
        BinaryStringWithSubstringRepresents1ToN obj = new BinaryStringWithSubstringRepresents1ToN();
        System.out.println(obj.queryString("0110",3));
        System.out.println(obj.queryString("0110",4));
    }

}
