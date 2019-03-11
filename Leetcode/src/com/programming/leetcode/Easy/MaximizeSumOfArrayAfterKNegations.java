package com.programming.leetcode.Easy;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> negativeNumbers = new PriorityQueue<>();
        PriorityQueue<Integer> positiveNumbers = new PriorityQueue<>();

        for(int i : A){
            if(i >= 0) positiveNumbers.offer(i);
            else negativeNumbers.offer(i);
        }

        while(K-->0){
            if(!negativeNumbers.isEmpty()){
                positiveNumbers.offer(-negativeNumbers.poll());
            }else{
                negativeNumbers.offer(-positiveNumbers.poll());
            }
        }

        int sum = 0;
        while (!negativeNumbers.isEmpty()) sum += negativeNumbers.poll();
        while (!positiveNumbers.isEmpty()) sum += positiveNumbers.poll();
        return sum;
    }

    //Using single priority queue..
    public int largestSumAfterKNegationsV1(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations obj = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(obj.largestSumAfterKNegations(new int[]{4,2,3},1));
    }
}
