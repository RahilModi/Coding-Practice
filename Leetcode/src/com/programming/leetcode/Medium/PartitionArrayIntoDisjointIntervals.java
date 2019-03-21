package com.programming.leetcode.Medium;

public class PartitionArrayIntoDisjointIntervals {

    private int[] getMaxAtPos(int[] A){
        int[] max = new int[A.length];
        max[0] = A[0];
        for(int i = 1; i < A.length; i++){
            max[i] = Math.max(A[i],max[i-1]);
        }
        return max;
    }

    public int partitionDisjoint(int[] A) {
        int[] maxArr = getMaxAtPos(A);
        int left = 0, right = left+1;
        int leftMax = maxArr[left], rightMin = Integer.MAX_VALUE;
        while (right < A.length){
            rightMin = Math.min(rightMin, A[right]);
            if(leftMax > rightMin){
                left = right;
                leftMax = maxArr[left];
                rightMin = Integer.MAX_VALUE;
            }
            right++;
        }
        return left+1;
    }


    //One pass with O(1) space..
    public int partitionDisjointV1(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals obj = new PartitionArrayIntoDisjointIntervals();
        System.out.println(obj.partitionDisjoint(new int[]{32,57,24,19,0,24,49,67,87,87}));
        System.out.println(obj.partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(obj.partitionDisjoint(new int[]{1,1,1,0,6,5}));
    }

}
