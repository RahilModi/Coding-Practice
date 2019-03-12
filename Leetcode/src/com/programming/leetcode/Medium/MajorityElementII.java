package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = -1, num2 = -2, count1 = 0, count2 = 0;
        for(int num : nums){
            if(num == num1){
                count1++;
            }else if(num == num2){
                count2++;
            }else if(count1 == 0){
                num1 = num;
                count1++;
            }else if(count2 == 0){
                num2 = num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int i : nums){
            if(i == num1) count1++;
            else if(i == num2) count2++;
        }

        double minCount= (double) nums.length /3;
        if(count1 > minCount) res.add(num1);
        if(count2 > minCount) res.add(num2);
        return res;
    }

    public static void main(String[] args) {
        MajorityElementII obj = new MajorityElementII();
        System.out.println(obj.majorityElement(new int[]{3,2,3,3,2,2,5,5}));
    }

}
