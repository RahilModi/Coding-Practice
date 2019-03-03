package com.programming.leetcode.Hard;

public class MaximumAverageSubArrayII {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = -Double.MAX_VALUE;
        if(nums == null || nums.length==0 || k > nums.length) return maxAvg;
        int sum, index, maxSum, prevSum;
        sum = index = prevSum=0;
        for(int j = k;j <= nums.length; j++) {
            maxSum = Integer.MIN_VALUE;
            while (index < nums.length) {
                sum += nums[index];
                if(index == j-1){
                    prevSum = sum;
                }
                if(index >= j -1){
                    maxSum = Math.max(maxSum, sum);
                    sum -= nums[index-j+1];
                }
                index++;
            }
            double crtAvg = (double)maxSum/j;
            maxAvg = Math.max(maxAvg, crtAvg);
            sum = prevSum;
            index = j;
        }
        return maxAvg;
    }

    //Check out Discussion for detailed explanation....
    public double findMaxAverageV1(int[] nums, int k) {
        double l = -10001, r = 100001;
        while(r-l > 0.00001) {
            double m = l + (r - l) / 2;
            if (canFindLargerAverage(nums, k, m)) {
                l = m;
            }
            else {
                r = m;
            }
        }
        return l;
    }

    private boolean canFindLargerAverage(int[] nums, int k, double x) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - x;
        }
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) {
            cur += a[i];
        }
        if (cur >= 0) {
            return true;
        }
        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];
            if (prev < 0) {
                cur -= prev;
                prev = 0;
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaximumAverageSubArrayII obj = new MaximumAverageSubArrayII();
        System.out.println(obj.findMaxAverage(new int[]{-1},1));
        System.out.println(obj.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
