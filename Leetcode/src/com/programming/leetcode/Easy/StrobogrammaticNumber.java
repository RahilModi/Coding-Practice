package com.programming.leetcode.Easy;

/***
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {

    boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length()-1;
        while(i <= j){
            char c1 = num.charAt(i), c2 = num.charAt(j);
            int mul = (c1-'0') * (c2-'0');
            //54 == 6 * 9 , 64 == 8 * 8
            if(mul == 1 || mul == 54 || mul == 64 || (mul == 0 && c1 ==c2)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber obj = new StrobogrammaticNumber();
        System.out.println(obj.isStrobogrammatic("121"));
        System.out.println(obj.isStrobogrammatic("69"));
        System.out.println(obj.isStrobogrammatic("818"));
        System.out.println(obj.isStrobogrammatic("619"));
        System.out.println(obj.isStrobogrammatic("116911"));
        System.out.println(obj.isStrobogrammatic("688889"));
    }
}
