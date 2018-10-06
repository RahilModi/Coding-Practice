package com.programming.leetcode.Easy;

public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder strBld = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch >= 65 && ch <= 90) {
                strBld.append((char) (ch + 32));
            }else{
                strBld.append(ch);
            }
        }
        return strBld.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("HELLO"));
        System.out.println(new ToLowerCase().toLowerCase("Hello"));
    }
}

