package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i + 9 < s.length(); i++){
            String str = s.substring(i,i+10);
            if(!visited.add(str)) {
                repeated.add(str);
            }
        }
        return Arrays.asList(repeated.toArray(new String[repeated.size()]));
    }

}
