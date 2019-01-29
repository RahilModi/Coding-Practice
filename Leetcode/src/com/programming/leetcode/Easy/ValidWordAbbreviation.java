package com.programming.leetcode.Easy;

public class ValidWordAbbreviation {
    public boolean isValidAbbreviation(String word, String abrv){
        int i = 0, j = 0, n = word.length(), m = abrv.length();
        while(i < n && j < m){
            if(Character.isDigit(abrv.charAt(j))){
                if(abrv.charAt(j)=='0')return false;
                StringBuilder sb = new StringBuilder();
                while(j < m && Character.isDigit(abrv.charAt(j))){
                    sb.append(abrv.charAt(j++));
                }
                int val = Integer.parseInt(sb.toString());
                i += val;
            }
            else if(abrv.charAt(j++) != word.charAt(i++)) return false;
        }
        return i == n &&j == m;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation obj =new ValidWordAbbreviation();
        System.out.println(obj.isValidAbbreviation("word","w3"));
        System.out.println(obj.isValidAbbreviation("word","4"));
        System.out.println(obj.isValidAbbreviation("word","2r1"));
        System.out.println(obj.isValidAbbreviation("word","wo2"));

    }
}
