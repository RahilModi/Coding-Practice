package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int count=1;
        for(int i = 1; i < S.length() ; i++){
            count = 1;
            while(i < S.length() && S.charAt(i) == S.charAt(i-1)){
                count++;
                i++;
            }
            if(count >= 3){
                List<Integer> list = new ArrayList<>();
                list.add(i-count);
                list.add(i-1);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new LargeGroups().largeGroupPositions("abcxxxxyz");
    }

}
