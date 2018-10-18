package com.programming.GeeksForGeeks.SlidingWindowTechnique;

public class SubArraySumWithinRange {

    public int numOfSubarraysWinthinRange(int[] arr, int left, int right){
        int window_sum = 0, countSubArray=0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length;j++){
                window_sum += arr[j];
                if(window_sum >= left && window_sum <= right) countSubArray++;
            }
            window_sum = 0;
        }
        return countSubArray;
    }

    private int countSubArraysLEtoK(int [] nums, int target){
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum > target){
                sum -= nums[left++];
            }
            count += (right - left + 1);
            right++;
        }
        return count;

    }


    //Technique is find num of subarrays having sum less than or Equal to R and less than or Equal to L-1 and return the difference
    public int numOfSubarraysWinthinRangeV2(int[] arr, int left, int right){
        return countSubArraysLEtoK( arr, right) - countSubArraysLEtoK(arr, left-1);
    }

    public static void main(String[] args) {
        SubArraySumWithinRange obj = new SubArraySumWithinRange();
        System.out.println(obj.numOfSubarraysWinthinRange(new int[]{2, 3, 5, 8}, 4, 13));
        System.out.println(obj.numOfSubarraysWinthinRangeV2(new int[]{1,4,6}, 3, 8));
    }
}
