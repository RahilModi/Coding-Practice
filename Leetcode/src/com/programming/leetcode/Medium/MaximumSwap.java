package com.programming.leetcode.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSwap {

    static class Digit{
        int val, pos;

        public Digit(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    //O(nlogn)
    public int maximumSwap(int num) {
        int[] buckets = new int[10];
        //PriorityQueue<Digit> pq = new PriorityQueue<>((a,b)->a.val == b.val ? a.pos - b.pos : b.val-a.val);
        PriorityQueue<Digit> pq = new PriorityQueue<>(new Comparator<Digit>() {
            @Override
            public int compare(Digit o1, Digit o2) {
                return o1.val == o2.val ? o1.pos-o2.pos : o2.val-o1.val;
            }
        });
        char[] arr = Integer.toString(num).toCharArray();
        int i = 0;
        for(char c : arr){
            pq.add(new Digit(c-'0', i++));
            buckets[c-'0']++;
        }
        i=0;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() && pq.peek().pos == i){
            buckets[pq.poll().val]--;
            i++;
        }
        if(!pq.isEmpty()) {
            while (buckets[pq.peek().val]!=1){
                buckets[pq.poll().val]--;
            }
            arr[pq.peek().pos] = arr[i];
            arr[i] = (char) (pq.peek().val+'0');
        }
        return Integer.parseInt(String.valueOf(arr));
    }

    //O(n)
    public int maximumSwapV1(int num) {
        int[] buckets = new int[10];
        char[] digitArray = String.valueOf(num).toCharArray();
        for(int i = 0; i < num; i++){
            int crt_val = digitArray[i]-'0';
            buckets[crt_val] = i;
        }
        for(int i = 0 ; i < digitArray.length; i++){
            for(int k = 9; k > digitArray[i]-'0'; k--){
                if(buckets[k] > i){
                    char temp = digitArray[i];
                    digitArray[i] = (char) (k);
                    digitArray[buckets[k]] = temp;
                    return Integer.valueOf(String.valueOf(digitArray));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap obj = new MaximumSwap();
        System.out.println(obj.maximumSwap(1993));
        System.out.println(obj.maximumSwap(98368));
    }

}
