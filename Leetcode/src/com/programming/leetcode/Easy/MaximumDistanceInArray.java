package com.programming.leetcode.Easy;

import java.util.PriorityQueue;

/****
 * Given  m arrays and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers  a and  b to be their absolute difference  |a-b|. Is to find the maximum distance.
 *
 * Example 1:
 *
 * Input:
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 *
 * Note:
 *
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the  m arrays will be in the range of [2, 10000].
 * The integers in the  m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceInArray {

    static class Element{
        int val;
        int arr_num;

        public Element(int val, int arr_num) {
            this.val = val;
            this.arr_num = arr_num;
        }
    }

    private PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
    private PriorityQueue<Element> maxHeap = new PriorityQueue<>((a,b)->b.val-a.val);

    public int maxDistance(int[][] arr) {
        for(int i = 0; i < arr.length ; i++){
            int[] input = arr[i];
            int len = input.length;
            if(len>0) {
                minHeap.offer(new Element(input[0],i));
                maxHeap.offer(new Element(input[len-1],i));
            }
        }
        Element minNum = minHeap.poll();
        Element maxNum = maxHeap.poll();
        if(minNum.arr_num != maxNum.arr_num) return Math.abs(maxNum.val-minNum.val);
        else
            return Math.max(Math.abs(maxHeap.peek().val-minNum.val), Math.abs(maxNum.val-minHeap.peek().val));
    }


    //Using no Extra Space...just two varibales so O(1)
    public int maxDistanceInAnArray(int[][] arr){
        int res = 0, start = arr[0][0], end = arr[0][arr[0].length-1];
        for(int i = 1; i < arr.length; i++){
            res = Math.max(res, Math.max(Math.abs(end-arr[i][0]), Math.abs(arr[i][arr[i].length-1]-start)));
            start = Math.min(start, arr[i][0]);
            end = Math.max(end, arr[i][arr[i].length-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{-1,2,3},{6},{-2,2,4,5}};
        MaximumDistanceInArray obj =new MaximumDistanceInArray();
        System.out.println(obj.maxDistance(input));
        System.out.println(obj.maxDistanceInAnArray(input));
    }

}
