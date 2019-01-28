package com.programming.leetcode.Medium;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;
        int count = 1 , cur = 2;
        while(cur < nums.length){
            if(nums[cur] > nums[count] || nums[cur] != nums[count-1] ){
                nums[++count] = nums[cur];
            }
            cur++;
        }
        return count+1;
    }

    public int removeDuplicatesV2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2]) //at most 2 duplicates are allowed if no duplicates are allowed then i<1 || n > nums[i-1]
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(obj.removeDuplicates(new int[]{1,2,2,2,3,3,4,5,5,5,6}));
    }

}
