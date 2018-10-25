package com.programming.leetcode.Easy;

public class IsLongPressed {

    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length() || name.charAt(0) != typed.charAt(0)) return false;
        int i = 0;
        for(int ptr = 0; i < name.length() ; i++,ptr++){
            if(ptr >= typed.length()) break;
            if(name.charAt(i) == typed.charAt(ptr)) {
                continue;
            }
            while(ptr < typed.length() && typed.charAt(ptr-1) == typed.charAt(ptr)){
                ptr++;
            }
            if( ptr >= typed.length() || name.charAt(i)!=typed.charAt(ptr)) break;
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        IsLongPressed obj = new IsLongPressed();
        System.out.println(obj.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(obj.isLongPressedName("alex", "aaleex"));
        System.out.println(obj.isLongPressedName("pyplrz", "ppyypllr"));
    }

}
