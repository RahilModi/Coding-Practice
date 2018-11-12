package com.programming.leetcode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        StringBuilder strBld = new StringBuilder();
        for(String email : emails){
            String[] split = email.split("@");
            String localName;
            String[] temp = split[0].split("\\+");
            localName = String.join("", temp[0].split("\\."));
            strBld.append(localName);
            strBld.append("@");
            strBld.append(split[1]);
            uniqueEmails.add(strBld.toString());
            strBld.setLength(0);
        }
        return uniqueEmails.size();
    }

    public int numUniqueEmailsV2(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        StringBuilder strBld = new StringBuilder();
        for(String email : emails){
            boolean localName = true;
            boolean remove = false;
            for(char c: email.toCharArray()){
                if(localName){
                    if(c=='@'){
                        localName = false;
                        strBld.append(c);
                        continue;
                    }else if(c=='+'){
                        remove = true;
                    }else if(!remove && c!='.'){
                        strBld.append(c);
                    }
                }else{
                    strBld.append(c);
                }
            }
            uniqueEmails.add(strBld.toString());
            strBld.setLength(0);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        new NumUniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
