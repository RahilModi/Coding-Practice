package com.programming.leetcode.Medium;

public class OptimalDivision {

    //https://leetcode.com/problems/optimal-division/solution/
    //  to maximize a/b/c/d we have to first minimize b/c/d. Now our objective turns to minimize the expression b/c/d.
    public String optimalDivision(int[] input){
        if(input.length == 1) return input[0]+"";
        if(input.length == 2) return input[0]+"/"+input[1];
        StringBuilder res= new StringBuilder(input[0]+"/("+input[1]);
        for(int i = 2; i < input.length; i++){
            res.append("/"+input[i]);
        }
        res.append(")");
        return res.toString();
    }

    public static void main(String[] args) {
        OptimalDivision obj = new OptimalDivision();
        System.out.println(obj.optimalDivision(new int[]{1000,100,10,2}));
    }
}
