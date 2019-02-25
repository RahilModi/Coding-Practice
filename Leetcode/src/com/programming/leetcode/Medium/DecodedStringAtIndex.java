package com.programming.leetcode.Medium;

public class DecodedStringAtIndex {

    //Memory Limit Exceeds...
    public String decodeAtIndex(String S, int K) {
        if(S == null || S.isEmpty()) return null;
        if(K == 1) return String.valueOf(S.charAt(K-1));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <S.length(); i++){
            if(Character.isDigit(S.charAt(i))){
                int num = S.charAt(i)-'0';
                String crtStr = sb.toString();
                int crtIdex = 0;
                while (--num > 0){
                    sb.append(crtStr);
                    K-=crtStr.length();
                    while (K < 0){
                        K++;
                        crtIdex++;
                    }
                    if(K == 0) return String.valueOf(sb.charAt(sb.length()-1-crtIdex));
                }
            }else{
                sb.append(S.charAt(i));
                K--;
                if(K == 0) return String.valueOf(sb.charAt(sb.length()-1));
            }
        }
        return null;
    }

    public String decodeAtIndexV1(String S, int K) {
        if(S == null || S.isEmpty()) return null;
        if(K == 1) return String.valueOf(S.charAt(K-1));
        long N = 0l;
        int i;
        for(i = 0; N < K; i++){
            N = S.charAt(i) >= '0' && S.charAt(i) <= '9' ? N * (S.charAt(i)-'0') : N+1;
        }
        --i;
        while (true){
            if(Character.isDigit(S.charAt(i))){
                N /= (S.charAt(i)-'0');
                K %= N;
            }else if(K%N == 0) return ""+S.charAt(i);
            else N--;
            i--;
        }
    }

    public static void main(String[] args) {
        DecodedStringAtIndex obj = new DecodedStringAtIndex();
        System.out.println(obj.decodeAtIndexV1("leet2code3",10));
        System.out.println(obj.decodeAtIndexV1("ha22",5));
        System.out.println(obj.decodeAtIndexV1("a2345678999999999999999",1));
    }

}
