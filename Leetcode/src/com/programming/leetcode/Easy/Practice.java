package com.programming.leetcode.Easy;

import java.util.HashSet;
import java.util.Set;

public class Practice {

    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) return 0;
        Set<String> uniqueEmails = new HashSet<>();
        for(String str : emails){
            StringBuilder sb = new StringBuilder();
            boolean bFound = false, bDomain = false;
            for(char c : str.toCharArray()){
                if(c == '.' && !bDomain){
                    continue;
                }
                else if(c == '+'){
                    bFound = true;
                    continue;
                }
                else if(c=='@'){
                    bFound = false;
                    bDomain = true;
                }
                else if(!bFound) {
                    sb.append(c);
                }
            }
            if(sb.length() > 0)
                uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}
