package com.programming.leetcode.Medium;

import java.util.Arrays;

public class BagofTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int ptr1 = 0, ptr2 = tokens.length-1, res = 0, points = 0;
        while (ptr1 <= ptr2){
            if(P >= tokens[ptr1]){
                P-=tokens[ptr1++];
                res = Math.max(res, ++points);
            }else if(points > 0){
                points--;
                P+=tokens[ptr2--];
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BagofTokens obj = new BagofTokens();
        System.out.println(obj.bagOfTokensScore(new int[]{100,200,400,300},200));
    }
}
