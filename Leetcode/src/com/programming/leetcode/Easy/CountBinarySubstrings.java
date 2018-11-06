package com.programming.leetcode.Easy;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        Character prevChar = null;
        int prevCount = 0, ans = 0, otherNum = 0;
        for(int i = 0; i < s.length();){
            Character crt = s.charAt(i);
            if(prevChar != null && prevChar == crt){
               prevCount++;
               i++;
               continue;
            }
            if(prevChar == null){
                prevChar = crt;
                prevCount++;
                i++;
                continue;
            }
            while(i<s.length() && prevCount > 0 && prevChar != crt){
                ans++;
                prevCount--;
                otherNum++;
                if(++i < s.length())
                    crt = s.charAt(i);
                else
                    break;
            }
            prevCount = otherNum;
            otherNum = 0;
            prevChar = s.charAt(i-1);
        }
        return ans;
    }


    public static void main(String[] args) {
        Object obj = new CountBinarySubstrings();
        System.out.println(((CountBinarySubstrings) obj).countBinarySubstrings("00110011"));
        System.out.println(((CountBinarySubstrings) obj).countBinarySubstrings("10101"));
        System.out.println(((CountBinarySubstrings) obj).countBinarySubstrings("1110000100"));
    }
}
