package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoList {

    public String[] findRestaurant(String[] list1, String[] list2) {

        if(list1.length == 0 || list2.length == 0) return new String[]{};

        Map<String, Integer> stringPos = new HashMap<>();
        for(int i = 0; i < list1.length ; i++){
            stringPos.put(list1[i],i);
        }
        List<String> result = new ArrayList<>();
        int index = 0;
        int lastIndexSum = Integer.MAX_VALUE;
        for(String str : list2){
            if(stringPos.containsKey(str)){
                int firstInterestPreference = stringPos.get(str);
                if(lastIndexSum > (firstInterestPreference + index)){
                    result.clear();
                    lastIndexSum = firstInterestPreference + index;
                    result.add(str);
                }else if(lastIndexSum == firstInterestPreference + index){
                    result.add(str);
                }
            }
            index++;
        }

        return result.toArray(new String[result.size()]);

    }

    public static void main(String[] args) {
        for(String str : new MinimumIndexSumOfTwoList().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})){
            System.out.println(str);
        }
    }

}
