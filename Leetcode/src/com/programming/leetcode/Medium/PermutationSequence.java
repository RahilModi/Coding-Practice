package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSequence {

    //https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i =1; i<=n; i++){
            nums.add(i);
        }
        int[]factorial = new int[n+1];
        factorial[0]=1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1]*i;
        }
        k-=1;
        StringBuilder sb = new StringBuilder();
        for(int i =1; i <= n; i++){
            int index = k / factorial[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k - index * factorial[n-i];
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        PermutationSequence obj = new PermutationSequence();
        System.out.println(obj.getPermutation(4,14));
    }

}
