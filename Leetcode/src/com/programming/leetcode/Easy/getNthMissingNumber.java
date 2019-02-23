package com.programming.leetcode.Easy;

public class getNthMissingNumber {

    //[1,3,5,8,10] => Missings [2,4,6,7,9] => 4th == 7

    public int getNumberMissingsBetweenRange(int[] nums, int i, int j){
        return (nums[j]-nums[i]+1)-(j-i+1);
    }

    public int getNthMissingFromSortedArray(int[] nums, int n){
        int l = 0, r=nums.length-1;
        while (l+1<r){
            int mid = l + (r-l)/2;
            int numsMissing=getNumberMissingsBetweenRange(nums,l,mid);
            if(numsMissing >= n){
                r = mid;
            }else{
                n-=numsMissing;
                l = mid;
            }
        }
        int num = nums[l];
        while (n-->0){
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        getNthMissingNumber obj = new getNthMissingNumber();
        System.out.println(obj.getNthMissingFromSortedArray(new int[]{1,3,5,8,10}, 2));
    }
}
