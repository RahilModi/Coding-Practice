package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaximumGap {

    //We can do bucket sort, radix sort and pigeonhole sort
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        if(nums.length == 2) return Math.abs(nums[0]-nums[1]);
        radix_sort(nums);
        int res = 0;
        for(int i = 1;i < nums.length; i++){
            res = Math.max(nums[i]-nums[i-1], res);
        }
        return res;
    }

    private void radix_sort(int[] arr){
        int max_elem = Arrays.stream(arr).max().getAsInt();
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for(int exp = 1 ; max_elem/exp > 0 ; exp *=10) {
            countSortForRadix(arr, exp);
        }
    }

    private void countSortForRadix(int[] arr, int exp){
        int[] count_sorted = new int[arr.length];
        int[] buckets = new int[10];
        for(int i = 0; i < arr.length; i++){
            buckets[(arr[i]/exp)%10]++;
        }
        for(int i = 1; i < 10; i++){
            buckets[i] += buckets[i-1];
        }
        for(int i = arr.length-1; i >= 0; i--){
            count_sorted[buckets[(arr[i]/exp) % 10 ]-1] = arr[i];
            buckets[(arr[i]/exp) %10]--;
        }
        System.arraycopy(count_sorted,0,arr,0,count_sorted.length);
    }

    //from the leetcode discussion..
    public int maximumGapV2(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        int[] bucketsMIN = new int[num.length - 1];
        int[] bucketsMAX = new int[num.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i:num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE &&
                    bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }

    public static void main(String[] args) {
        MaximumGap obj = new MaximumGap();
        System.out.println(obj.maximumGapV2(new int[]{3,6,9,1}));
    }

}
