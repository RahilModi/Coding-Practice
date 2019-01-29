package com.programming.leetcode.Medium;

public class LongestUncommonSequence {

    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        LongestUncommonSequence obj = new LongestUncommonSequence();
        System.out.println(obj.findLUSlength("aba","cdc"));
    }
}
