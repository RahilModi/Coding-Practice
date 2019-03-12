package com.programming.leetcode.Easy;

public class MajorityElement {

    //MOORE VOTING ALGORITHM
    public int majorityElement(int[] nums) {
        int count = 0, ret = 0;
        for(int num : nums){
            if(count == 0) ret = num;
            if(num != ret){
                count--;
            }else{
                count++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{3,2,4,3,3}));
    }

}
