package com.programming.leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    final int lemonade_cost = 5;
    final int[][] pairs= new int[][]{{5,5,5},{5,10}};

    public boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> collection = new HashMap<>();

        for(int bill : bills){

            if(bill - lemonade_cost == 0) {
                collection.put(bill, collection.getOrDefault(bill, 0) +  1);
                continue;
            }

            int changerequired = (bill - lemonade_cost);

            if(collection.get(5) == null || collection.get(5)==0) return false;

            int num5 = collection.get(5);

            Integer num10 = collection.get(10);

            if(changerequired == lemonade_cost){
                if(collection.get(changerequired) == null || collection.get(changerequired) == 0){
                    return false;
                }else{
                    collection.put(changerequired, collection.get(changerequired) - 1);
                    collection.put(bill, collection.getOrDefault(bill, 0)+1);
                }
            }else{
                if(changerequired == 10){
                    collection.put(5, num5 - 1);
                    collection.put(bill, collection.getOrDefault(bill, 0)+1);
                }else{
                    if(num10 != null && num5 > 0 && num10 > 0){
                        collection.put(bill, collection.getOrDefault(bill, 0)+1);
                        collection.put(5,num5 -1);
                        collection.put(10, num10 -1);
                    }else if(num5 >= 3){
                        collection.put(5, num5 - 3);
                        collection.put(bill,collection.getOrDefault(bill,0)+1);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;

    }


    public boolean lemonadeChangeV2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{10,10,20}));
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5,5,5,10,10,20}));
    }
}
