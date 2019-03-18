package com.programming.leetcode.Medium;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, sum = 0;
        for(int i =0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                total += sum;
                start = i+1;
                sum = 0;
            }
        }
        total += sum;
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        GasStation obj = new GasStation();
        System.out.println(obj.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

}
