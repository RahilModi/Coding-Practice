package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParantheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                List<Integer> part1Ways = diffWaysToCompute(input.substring(0,i));
                List<Integer> part2Ways = diffWaysToCompute(input.substring(i+1));

                for(int p1 : part1Ways){
                    for(int p2 : part2Ways){
                        int ans = 0;
                        switch (c){
                            case '+' : {
                                ans = p1 + p2;
                                break;
                            }
                            case '-' : {
                                ans = p1 - p2;
                                break;
                            }
                            case '*' : {
                                ans = p1 * p2;
                                break;
                            }
                        }
                        res.add(ans);
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParantheses obj = new DifferentWaysToAddParantheses();
        System.out.println(obj.diffWaysToCompute("2*3-4*5"));
    }
}
