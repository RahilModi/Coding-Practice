package com.programming.leetcode.Medium;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0) continue;
            int j = i, k = getNextIndex(i, nums);
            while (nums[k]*nums[i] > 0 && nums[getNextIndex(k, nums)]*nums[i] > 0){
                if(j == k){
                    if(j == getNextIndex(j, nums)){
                        break;
                    }
                    return true;
                }
                j = getNextIndex(j, nums);
                k = getNextIndex(getNextIndex(k,nums),nums);
            }

            j = i;
            int val = nums[i];
            while (nums[j]*val > 0){
                int next = getNextIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getNextIndex(int i, int[] arr){
        int next = i + arr[i], n = arr.length;
        return next >= 0 ? next % n : n + (next % n);
    }

    public static void main(String[] args) {
        CircularArrayLoop obj = new CircularArrayLoop();
        System.out.println(obj.circularArrayLoop(new int[]{-1}));
        System.out.println(obj.circularArrayLoop(new int[]{2,2,2,2,2,4,7}));

        System.out.println(obj.circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
        System.out.println(obj.circularArrayLoop(new int[]{-1,2}));
        System.out.println(obj.circularArrayLoop(new int[]{2,-1,1,2,2}));
    }


}
