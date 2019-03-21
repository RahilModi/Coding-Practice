package com.programming.leetcode.Medium;

public class ValidateIPAddress {

    public boolean IPv4Validator(String IP){
        if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return false;
        String[] tokens = IP.split("\\.");
        if(tokens.length != 4) return false;
        for(int i = 0; i < tokens.length; i++){
            int tokenVal;
            try{
                tokenVal = Integer.parseInt(tokens[i]);
            }catch (NumberFormatException ex){
                return false;
            }
            if(tokens[i].charAt(0) == '-' || (tokens[i].length() > 1 && tokens[i].charAt(0) == '0') || tokenVal < 0 || tokenVal > 255) return false;
        }
        return true;
    }
    public boolean IPv6Validator(String IP){
        if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
        String[] tokens = IP.split(":");
        if(tokens.length != 8) return false;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].isEmpty() || tokens[i].length() > 4) return false;
            if(!isContainsHexaDigitsOnly(tokens[i])) return false;
        }
        return true;
    }

    private boolean isContainsHexaDigitsOnly(String token){
        for(char c : token.toCharArray()){
            if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >='A' && c <= 'F'))) return false;
        }
        return true;
    }

    public String validIPAddressRegex(String IP) {
        if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
        return "Neither";
    }

    public String validIPAddress(String IP) {
        if(IP == null || IP.isEmpty()) return "Neither";
        if(IP.indexOf(".") > 0 && IPv4Validator(IP)) return "IPv4";
        else if(IP.indexOf(":") > 0 && IPv6Validator(IP)) return "IPv6";
        else return "Neither";
    }

    public static void main(String[] args) {
        ValidateIPAddress obj = new ValidateIPAddress();
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(obj.validIPAddress("1e1.4.5.6"));
        System.out.println(obj.validIPAddress("172.16.254.1"));
        System.out.println(obj.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(obj.validIPAddress("256.256.256.256"));
    }

}
