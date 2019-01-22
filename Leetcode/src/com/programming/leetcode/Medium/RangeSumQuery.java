package com.programming.leetcode.Medium;

import java.util.Arrays;

public class RangeSumQuery {

    int prefixsum_arr[];
    int input[];

    public RangeSumQuery(int[] nums) {
        this.prefixsum_arr = new int[nums.length];
        this.input = nums;
        makePrefixSumArray(this.input);
    }

    private void makePrefixSumArray(int [] nums) {
        for (int i = 0; i < nums.length ; i++){
            if(i > 0){
                prefixsum_arr[i] = prefixsum_arr[i-1] + nums[i];
            }else{
                prefixsum_arr[i] = nums[i];
            }
        }
    }

    public void update(int i, int val) {
        int diff = val-this.input[i];
        this.input[i] = val;
        for(int k = i; k < this.prefixsum_arr.length; k++){
            this.prefixsum_arr[k] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return i > 0 ? prefixsum_arr[j] - prefixsum_arr[i-1] : prefixsum_arr[j];
    }

    private void printArray(){
        System.out.println(Arrays.toString(this.prefixsum_arr));
    }

    public static void main(String[] args) {
        RangeSumQuery r = new RangeSumQuery(new int[]{7,2,7,2,0});
        r.update(4,6);
        r.printArray();
        r.update(0,2);
        r.printArray();
        r.update(0,9);
        r.printArray();
        r.sumRange(4,4);
        r.printArray();
        r.update(3,8);
        r.printArray();
        r.update(0,8);
        r.printArray();
    }

}
