package com.programming.leetcode.Easy;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) return true;
        boolean[] alreadyMapped = new boolean[256];
        char[] charsMap = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char crt = s.charAt(i);
            if (charsMap[(int) crt] == '\u0000') {
                if (!alreadyMapped[t.charAt(i)]) {
                    charsMap[(int) crt] = t.charAt(i);
                    alreadyMapped[t.charAt(i)] = true;
                } else return false;
            } else {
                char t_mapped = charsMap[(int) crt];
                if (t_mapped != t.charAt(i)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("egg", "add"));
        System.out.println(obj.isIsomorphic("foo", "bar"));
        System.out.println(obj.isIsomorphic("paper", "title"));
    }
}
