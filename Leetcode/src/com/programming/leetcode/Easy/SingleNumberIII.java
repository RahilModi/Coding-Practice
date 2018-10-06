package com.programming.leetcode.Easy;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int xor = 0;

        for(int n : nums){
            xor ^= n;
        }

        xor &= -xor;

        int x = 0 ,y = 0;

        for(int n : nums){
            if( (n & xor) ==  0){
                x ^= n;
            }else{
                y ^= n;
            }
        }

        return new int[]{x,y};

    }

    public static void main(String[] args) {
        int[] result = new SingleNumberIII().singleNumber(new int[]{1,2,1,3,2,5});
        for(int i : result) System.out.println(i);
    }

}
