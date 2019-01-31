package com.programming.leetcode.Medium;

public class RomanToInt {

    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int[] nums = new int[s.length()];
        int i = 0;
        for(char c : charArray) {
            switch(c) {
                case 'M' :
                    nums[i++] = 1000;
                    break;
                case 'D' :
                    nums[i++] = 500;
                    break;
                case 'C' :
                    nums[i++] = 100;
                    break;
                case 'L' :
                    nums[i++] = 50;
                    break;
                case 'X' :
                    nums[i++] = 10;
                    break;
                case 'V' :
                    nums[i++] = 5;
                    break;
                case 'I' :
                    nums[i++] = 1;
                    break;
            }
        }
        int sum = 0;
        int j = 0;
        for(j = 0; j < nums.length - 1; j++) {
            if(nums[j] < nums[j + 1])
                sum -= nums[j];
            else
                sum += nums[j];
        }
        sum += nums[j]; //Will add last element
        return sum ;
    }

    public static void main(String[] args) {
        RomanToInt obj = new RomanToInt();
        System.out.println(obj.romanToInt("MCM"));
    }
}
