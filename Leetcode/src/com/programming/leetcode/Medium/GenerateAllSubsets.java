package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {

    public List<List<String>> generateAllSubsets(String[] input){
        List<List<String>> res = new ArrayList<>();
        backtrack(0, input, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int index, String[] input, List<List<String>> res, List<String> crt){
        res.add(new ArrayList<>(crt));
        for(int i = index; i < input.length; i++){
            crt.add(input[i]);
            backtrack(i+1, input, res, crt);
            crt.remove(crt.size()-1);
        }
    }

    //Combinatorics...
    public List<List<String>> generateAllSubsetsV1(String[] input){
        List<List<String>> res = new ArrayList<>();
        int n = input.length;
        int max = 1 << n;
        for(int i = 0; i < max; i++){
            res.add(generateSubset(i, input));
        }
        return res;
    }

    public List<String> generateSubset(int index, String[] input){
        List<String> crt = new ArrayList<>();
        int i = 0;
        for(int k = index; k > 0; k>>=1){
           if((k&1) == 1) crt.add(input[i]);
           i++;
        }
        return crt;
    }

    public static void main(String[] args) {
        GenerateAllSubsets obj = new GenerateAllSubsets();
        for(List<String> r : obj.generateAllSubsetsV1(new String[]{"a","b","c"})){
            System.out.println(r);
        }
        for(List<String> r : obj.generateAllSubsets(new String[]{"a","b","c"})){
            System.out.println(r);
        }
    }

}
