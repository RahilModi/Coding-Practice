package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 * Given a list of list of Strings. Print cartesian product of lists.
 * input -> {"Hello", "World"} , {"Game"}, {"Go","Home"}
 * output ->
 * Hello Game Go
 * Hello Game Home
 * World Game Go
 * World Game Home
 */
public class WordCombinations {

    public List<String> printCombinations(List<List<String>> input) {
        List<String> res = new ArrayList<>();
        generateCombinationsLikeCartesianProduct(input,res,new String[input.size()],0);
        return res;
    }

    public void generateCombinationsLikeCartesianProduct(List<List<String>> input, List<String> result, String[] combinationArr, int pos){
        if(pos == combinationArr.length){
            result.add(Arrays.toString(combinationArr));
            return;
        }

        for(int i = 0; i < input.get(pos).size();i++){
            combinationArr[pos] = input.get(pos).get(i);
            generateCombinationsLikeCartesianProduct(input,result,combinationArr,pos+1);
        }
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("quick");
        l1.add("slow");

        List<String> l2 = new ArrayList<>();
        l2.add("brown");
        l2.add("red");

        List<String> l3 = new ArrayList<>();
        l3.add("fox");
        l3.add("dog");

        List<List<String>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        input.add(l3);
        WordCombinations wc = new WordCombinations();
        for(String combs: wc.printCombinations(input)){
            System.out.println(combs);
        }
    }



}
