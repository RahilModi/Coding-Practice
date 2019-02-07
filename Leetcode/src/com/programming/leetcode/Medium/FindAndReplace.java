package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindAndReplace {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder strBld = new StringBuilder();
        int id = 0, startIdx = 0;
        Map<Integer, String> pair = new TreeMap<>();
        for(String source: sources){
            int index = indexes[id];
            if(S.substring(index,index+source.length()).equals(source)){
                pair.put(index,source+"-"+targets[id]);
            }
            id++;
        }
        for(int i : pair.keySet()){
            strBld.append(S.substring(startIdx,i));
            String[] operation = pair.get(i).split("-");
            startIdx = i+operation[0].length();
            strBld.append(operation[1]);
        }
        strBld.append(S.substring(startIdx));
        return strBld.toString();
    }

    //Leetcode solution....
    public String findReplaceStringV1(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        FindAndReplace obj = new FindAndReplace();
        System.out.println(obj.findReplaceString("abcd", new int[]{0,2}, new String[]{"a","cd"},new String[]{"www","fff"}));
    }
}
