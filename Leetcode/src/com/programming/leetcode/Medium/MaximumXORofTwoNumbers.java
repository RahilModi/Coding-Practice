package com.programming.leetcode.Medium;

public class MaximumXORofTwoNumbers {

    //O(n^2)
    public int findMaximumXOR(int[] nums) {
        int crtMax = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                crtMax = Math.max(crtMax, nums[i]^nums[j]);
            }
        }
        return crtMax;
    }

    //https://threads-iiith.quora.com/Tutorial-on-Trie-and-example-problems
    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie
    private class Trie{
        Trie[] children;
        public  Trie(){
            children = new Trie[2];
        }
    }
    public int findMaximumXORV1(int[] nums) {

        Trie root = new Trie();
        int maxBits = 0;
        for(int n : nums){
            maxBits = Math.max(maxBits, (int)(Math.log(n)/Math.log(2)+1));
        }
        for(int n : nums) {
            Trie crt = root;
            for (int i = maxBits; i >= 0; i--) {
                int crtBit = (n >>> i) & 1;
                System.out.println(crtBit);
                if(crt.children[crtBit] == null) crt.children[crtBit] = new Trie();
                crt = crt.children[crtBit];
            }
        }

        int crtMax = Integer.MIN_VALUE;
        for(int n : nums){
            Trie crt = root;
            int crtSum = 0;
            for (int i = maxBits; i >= 0; i--) {
                int crtBit = (n >>> i) & 1;
                if(crt.children[crtBit^1]!=null){
                    crtSum += (1<<i);
                    crt = crt.children[crtBit^1];
                }else crt = crt.children[crtBit];
            }
            crtMax = Math.max(crtMax, crtSum);
        }
        return crtMax;
    }


    public static void main(String[] args) {
        MaximumXORofTwoNumbers obj = new MaximumXORofTwoNumbers();
        System.out.println(obj.findMaximumXORV1(new int[]{3,10,5,25,2,8}));
        System.out.println(obj.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
