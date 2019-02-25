package com.programming.leetcode.Medium;

import java.util.Stack;

public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        for(int i = 0; i < nums.length -2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                if(nums[i] < nums[j]){
                    for(int k = j + 1 ; k < nums.length ; k++) {
                        if(nums[k] < nums[j]){
                            if (nums[k] > nums[i]) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean find132patternV1(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        for(int i = 0, min = Integer.MAX_VALUE; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            if(min == nums[i]) continue;

            for(int k = nums.length-1; k > i ; k--){
                if(min < nums[k] && nums[k] < nums[i]) return true;
            }
        }
        return false;
    }

    class Pair{
        int min,max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132patternV2(int[] nums) {
        Stack<Pair> numStack= new Stack<>();
        for(int n : nums){
            if(numStack.isEmpty() || n < numStack.peek().min) numStack.push(new Pair(n,n));
            else if(n > numStack.peek().min){
                Pair last = numStack.pop();
                if(n < last.max) return true;
                else{
                    last.max = n;
                    while (!numStack.isEmpty() && n >= numStack.peek().max) numStack.pop();
                    if(numStack.isEmpty() && numStack.peek().min < n) return true;
                    numStack.push(last);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Pattern132 obj = new Pattern132();
        System.out.println(obj.find132patternV2(new int[]{3,5,0,3,4}));
        System.out.println(obj.find132pattern(new int[]{3,1,4,2}));
    }

}
