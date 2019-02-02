package com.programming.leetcode.Medium;

import java.util.Arrays;
import java.util.Random;

/*Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

        You may assume the array's length is at most 10,000.
        Example:
            Input: [1,2,3]
            Output:2
        Explanation:Only two moves are needed (remember each move increments or decrements one element):
        [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
*/
//This solution relies on the fact that if we increment/decrement each element to the median of all the elements,
//the optimal number of moves is necessary. The median of all elements can be found in expected O(n) time using QuickSelect (or deterministic O(n) time using Median of Medians).
public class MinimumMovesToEqualArrayElementsII {

    ///Java8 version

    public int minMoves2Java8(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length >> 1];
        return Arrays.stream(nums).map(i -> Math.abs(median - i)).sum();
    }

    //O(nlogn)
    public int minMoves2V1(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int minMoves = 0;
        while (i<j){
            minMoves += Math.abs(nums[j--]-nums[i++]);
        }
        return minMoves;
    }

    //Find the median position and that helps in finding min moves requires to make all the same.
    public int minMoves2(int[] nums) {
        int median = quickSelect(nums, nums.length/2 + 1, 0, nums.length-1);
        int minMoves = 0;
        for(int i : nums){
            minMoves += Math.abs(i-median);
        }
        return minMoves;
    }

    private int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr,i, j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }


    private void swap(int [] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    //QuickSelect take O(n) to finding nth Pos in sorted array from the unsorted array
    private int quickSelect(int[] arr, int n, int low, int high){

        int index = partition(arr, low, high);

        if (index - low == n - 1)
            return arr[index];

        if (index - low > n - 1)
            return quickSelect(arr, n, low, index - 1);

        return quickSelect(arr, n - index + low- 1,index + 1, high);
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII obj = new MinimumMovesToEqualArrayElementsII();
        System.out.println(obj.minMoves2( new int[]{1,2,3}));
        System.out.println(obj.minMoves2V1( new int[]{1,2,3}));
    }

}
