package com.programming.leetcode.Medium;

public class IntegerBreak {


    public int integerBreak(int n) {

        if(n < 4) return  n-1;
        int product =1;
        while(n > 4){
            product *=3;
            n-=3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();
        System.out.println(obj.integerBreak(10));
    }
}
