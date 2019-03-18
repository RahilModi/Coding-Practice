package com.programming.leetcode.Easy;

public class ComplementOfBase10Integer {

    public int bitwiseComplement(int N) {
        int numBits = (int) Math.floor(Math.log(N)/Math.log(2))+1;
        return  N ^ ((1<<numBits)-1);
    }

    public static void main(String[] args) {
        ComplementOfBase10Integer obj = new ComplementOfBase10Integer();
        System.out.println(obj.bitwiseComplement(5));
    }
}
