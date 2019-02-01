package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RestoreIPAddress {

    //Backtracking...
    // Shared
    private static final int MAX_IP_RANGE = 255;
    private static final int MAX_IP_LENGTH = 3;
    private static final int IP_PARTITON = 4;

    // Shared
    // Time complexity: O(1)
    // Space complexity: O(1)
    private boolean isValid(String s) {
        return      0 < s.length() && s.length() <= MAX_IP_LENGTH
                && (s.length() == 1 || s.charAt(0) != '0')
                &&  Integer.parseInt(s) <= MAX_IP_RANGE;
    }

    // Backtracking (recursion)
    // Time complexity: O(n^4) with n the length of string
    // Space complexity: O(n^4)
    public List<String> restoreIpAddressesV1(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        List<String> ips = new ArrayList<>();
        restoreIpAddressesHelper(s, 0, 0, new StringBuilder(), ips);
        return ips;
    }

    private void restoreIpAddressesHelper(String s, int i, int cnt, StringBuilder builder, List<String> ips) {
        if (cnt == IP_PARTITON) {
            if (i == s.length()) {
                builder.deleteCharAt(builder.length() - 1);
                ips.add(builder.toString());
            }
            return;
        }

        // j: next start
        for (int j = i + 1; j <= s.length(); j++) {
            String substr = s.substring(i, j);

            if (!isValid(substr)) break;

            int len = builder.length();
            builder.append(substr);
            builder.append('.');
            restoreIpAddressesHelper(s, j, cnt + 1, builder, ips);
            builder.setLength(len);
        }
    }
    ////////

    static String pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private final static Pattern ipAddressPattern = Pattern.compile(pattern);
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        helper(s, 1,res);
        return res;
    }

    public boolean isValidIPAddess(String ipAddress){
        for(String segment : ipAddress.split("\\.")){
            if(segment.length() >= 2 && segment.startsWith("0")) return false;
        }
        return ipAddressPattern.matcher(ipAddress).matches();
    }

    public void helper(String S, int pos, List<String> res){
        StringBuilder sb = new StringBuilder();
        for(int i = pos; i < 4 && i< S.length()-2; i++){
            for(int j = i+ 1;j<i+4 && j< S.length()-1; j++){
                for(int k = j+1;k<j+4 && k < S.length();k++){
                    sb.append(S.substring(0,i));
                    sb.append(".");

                    sb.append(S.substring(i,j));
                    sb.append(".");
                    sb.append(S.substring(j,k));
                    sb.append(".");
                    sb.append(S.substring(k));
                    //System.out.println(sb.toString());
                    if(isValidIPAddess(sb.toString())){
                        res.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }

        }
    }

    public static void main(String[] args) {
        RestoreIPAddress obj = new RestoreIPAddress();
        //System.out.println(obj.isValidIPAddess("255.255.11.135"));
        for(String ip :obj.restoreIpAddresses("25525511135")){
            System.out.println(ip);
        }
    }
}
