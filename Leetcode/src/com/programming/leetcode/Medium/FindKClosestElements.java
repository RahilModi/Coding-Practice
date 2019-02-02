package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class FindKClosestElements {

    List<Integer> result = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int indexOfx = Arrays.binarySearch(arr,x);
        if(indexOfx < 0){
            indexOfx = -indexOfx -1;
        }
        int left = indexOfx - 1, right = indexOfx;
        while(left >=0 && right<arr.length && k > 0){
            if(Math.abs(x-arr[left]) <= Math.abs(arr[right]-x)){
                result.add(arr[left--]);
            }else {
                result.add(arr[right++]);
            }
            k--;
        }

        while(k>0 && left >=0){
            result.add(arr[left--]);
            k--;
        }

        while(k>0 && right < arr.length){
            result.add(arr[right++]);
            k--;
        }
        Collections.sort(result, (a,b)->a-b);
        return result;
    }

    //Sorting (nlogn)
    public List<Integer> findClosestElementsV1(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }

    //Binary Search..O(logn + k)
    public List<Integer> findClosestElementsV2(List<Integer> arr, int k, int x) {
        int n = arr.size();
        if (x <= arr.get(0)) {
            return arr.subList(0, k);
        } else if (arr.get(n - 1) <= x) {
            return arr.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(arr, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
                    high--;
                else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return arr.subList(low, high + 1);
        }
    }

    public static void main(String[] args) {
        FindKClosestElements obj =new FindKClosestElements();
        for(int i : obj.findClosestElements(new int[]{1,2,3,4,6,7,8},4,-1)){
            System.out.println(i);
        }
//        System.out.println(obj.findClosestElements(new int[]{1,2,3,4,6,7,8},4,5));
//        System.out.println(obj.findClosestElements(new int[]{1,2,3,4,5,6,7,8},4,2));
//        System.out.println(obj.findClosestElements(new int[]{1,2,3,4,5,6,7,8},4,11));
    }
}
