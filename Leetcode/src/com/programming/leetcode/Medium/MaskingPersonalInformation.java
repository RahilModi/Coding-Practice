package com.programming.leetcode.Medium;

public class MaskingPersonalInformation {

    public String maskPII(String S) {
        if(S == null || S.isEmpty()) return S;
        String country[] = { "" ,"+*-", "+**-", "+***-"};
        int idx = S.indexOf('@');
        if(idx > 0){
            return new StringBuilder().append(S.charAt(0)).append("*****").append(S.charAt(idx-1)).append(S.substring(idx)).toString().toLowerCase();
        }else{
            S = S.replaceAll("[^0-9]","");
            return new StringBuilder().append(country[S.length()-10]).append("***-***-").append(S.substring(S.length()-4)).toString();
        }
    }

    public static void main(String[] args) {
        MaskingPersonalInformation obj = new MaskingPersonalInformation();
        System.out.println(obj.maskPII("LeetCode@LeetCode.com"));
        System.out.println(obj.maskPII("86-(10)12345678"));
    }

}
