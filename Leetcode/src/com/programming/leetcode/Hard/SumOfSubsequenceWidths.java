package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Input: [2,1,3]
 * Output: 6
 * Explanation:
 * Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 * The sum of these widths is 6.
 */
public class SumOfSubsequenceWidths {

    //Time Limit Exceeds...
    long sum = 0;
    double mod = 1e9+7;
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        helper(A, 0, new ArrayList<>());
        return (int)((sum+mod)%mod);
    }

    public void helper(int[] A, int pos, List<Integer> res){
        if(!res.isEmpty()){
            sum += (res.get(res.size()-1)-res.get(0));
            sum %= mod;
        }

        for(int i = pos; i < A.length; i++){
            res.add(A[i]);
            helper(A, i+1, res);
            res.remove(res.size()-1);
        }
    }


    //https://leetcode.com/problems/sum-of-subsequence-widths/discuss/161267/C%2B%2BJava1-line-Python-Sort-and-One-Pass
    //For A[i]:
    //There are i smaller numbers,
    //so there are 2 ^ i sequences in which A[i] is maximum.
    //we should do res += A[i] * (2 ^ i)
    //
    //There are n - i - 1 bigger numbers,
    //so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
    //we should do res -= A[i] * 2 ^ (n - i - 1)
    //Runtime : O(NlogN + N)

    public int sumSubseqWidthsMathApproach(int[] A) {
        Arrays.sort(A);
        long sum = 0, c =1, mod = (long)1e9+7;
        for(int i = 0; i < A.length; i++){
            sum = (sum + A[i]*c - A[A.length-1-i]*c)%mod;   //When element at index 1 can be maximum for 1 time and same way element @ length-1-i is minimum for only 1 time.
            c = (c<<1) %mod;
        }
        return (int)((sum+mod)%mod);
    }

    public int sumSubseqWidthsMathApproachV1(int[] A) {
        Arrays.sort(A);
        long sum = 0, c =1, mod = (long)1e9+7;
        for(int i = 0; i < A.length; i++){
            sum = (sum + A[i]* ((1<<i)%mod) - A[i]*((1<<A.length-1-i)%mod))%mod;   //When element at index 1 can be maximum for 1 time and same way element @ length-1-i is minimum for only 1 time.
        }
        return (int)((sum+mod)%mod);
    }

    public static void main(String[] args) {
        System.out.println(1e9+7);
        SumOfSubsequenceWidths obj = new SumOfSubsequenceWidths();
        System.out.println(obj.sumSubseqWidths(new int[]{2,1,3}));
        System.out.println(obj.sumSubseqWidthsMathApproach(new int[]{2,1,3}));
        System.out.println(obj.sumSubseqWidthsMathApproach(new int[]{3,23,1,42,2,1,3}));

    }

}
