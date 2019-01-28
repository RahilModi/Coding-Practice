package com.programming.leetcode.Easy;

public class LicenseKeyFormatter {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i = S.length()-1; i >= 0; i -- ){
            if(S.charAt(i) != '-'){
                if(counter == K){
                    sb.insert(0,'-');
                    counter = 0;
                }
                sb.insert(0,Character.toUpperCase(S.charAt(i)));
                counter++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatter obj = new LicenseKeyFormatter();
        System.out.println(obj.licenseKeyFormatting("--a-a--a-a--",2));
    }
}
