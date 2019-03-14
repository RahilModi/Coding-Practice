package com.programming.leetcode.Medium;

public class ArrayNesting {

    Integer maxVal = Integer.MIN_VALUE;
    public int arrayNesting(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        for(int i = 0; i < nums.length ; i++){
            if(seen[i])continue;
            maxVal = Math.max(maxVal, calMaxLength(i, nums, seen));
        }
        return maxVal;
    }

    private int calMaxLength(int index, int[] nums, boolean[] visited){
        int i = index, count = 0;
        while (count == 0 || i != index){
            visited[i] = true;
            i = nums[i];
            count++;
        }
        return count;
    }

    public int arrayNestingV1(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int crtLen = 0, nextPos = i;
            for(int k = nextPos; nums[k] >= 0; k = nextPos){
                nextPos = nums[k];
                nums[k] = -1;
                crtLen++;
            }
            maxLen = Math.max(maxLen, crtLen);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(new ArrayNesting().arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
