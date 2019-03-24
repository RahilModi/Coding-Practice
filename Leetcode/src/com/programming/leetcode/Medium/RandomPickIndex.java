package com.programming.leetcode.Medium;

import java.util.*;


//Reservoir Sampling...
//Great idea! I was wondering if every index probability distributes equally.
//I did some math and looks like yes, all the indexes of the duplicate numbers have equal 1/n probability (where n is a number of duplicates).
//This is trivial for the last index, it's just 1/count. But what about the first one? At first try, the first index will be selected with a probability of 100%,
//but what's next? Let's try to multiply 1 * (1 - 1/2) * (1 - 1/3) * (1 - 1/4) * ... * (1 - 1/n) = 1 * 1/2 * 2/3 * 3/4 * ... * n-1/n = (n - 1)! / n! = 1 / n
public class RandomPickIndex {

    int[] arr;
    Random random;
    Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
    public RandomPickIndex(int[] nums) {
        random = new Random();
        this.arr = nums;
        //Below code is only for V1 solution where O(N) extra memory but pick is O(1)
        for(int i = 0; i < nums.length; i++) {
            numIndexMap.computeIfAbsent( nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    //O(N) pick time
    public int pick(int target) {
        int count = 0, result = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target && random.nextInt(++count) == 0){
                result = i;
            }
        }
        return result;
    }

    //O(1) pick time
    public int pickV1(int target) {
        int size = numIndexMap.get(target).size();
        return numIndexMap.get(target).get(random.nextInt(size));
    }

}
