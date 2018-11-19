package com.programming.leetcode.Easy;

public class DIString {

    public int[] diStringMatch(String S) {
        int num1 = 0, num2 = S.length();
        int [] res  = new int[S.length()+1];
        int index = 0;
        for(char c : S.toCharArray()){
            res[index] = c=='I' ? num1++ : num2--;
            index++;
        }
        res[index]=num1;
        return res;
    }

    public static void main(String[] args) {
        for(int i : new DIString().diStringMatch("IDID")){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : new DIString().diStringMatch("III")){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : new DIString().diStringMatch("DDI")){
            System.out.print(i+" ");
        }
    }

}
