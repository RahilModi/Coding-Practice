package com.programming.leetcode.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for(int i = 0; i < quality.length; i++){
            workers[i] = new double[]{(double) wage[i]/quality[i], (double)quality[i]};
        }

        Arrays.sort(workers, (a,b)->Double.compare(a[0],b[0]));

        Double totalCost = Double.MAX_VALUE, qsum = 0.0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(double[] worker : workers){
            qsum +=worker[1];
            pq.add(-worker[1]);
            if(pq.size() > K) qsum += pq.poll();
            if(pq.size() == K) totalCost = Math.min(totalCost,qsum*worker[0]);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        MinCostToHireKWorkers obj = new MinCostToHireKWorkers();
        System.out.println(obj.mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30},2));
    }
}
