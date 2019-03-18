package com.programming.leetcode.Medium;

public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() -t.length()) > 1) return false;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        OneEditDistance obj = new OneEditDistance();
        System.out.println(obj.isOneEditDistance("ab","acb"));
    }
}
