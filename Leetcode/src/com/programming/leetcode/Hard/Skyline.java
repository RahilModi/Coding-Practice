package com.programming.leetcode.Hard;

import java.util.*;

public class Skyline {

    class buildingPoint implements Comparable{
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(Object o) {
            if(o instanceof  buildingPoint) {
                buildingPoint p = (buildingPoint) o;
                if (p.x != this.x) return this.x - p.x;
                else {
                    return (this.isStart ? -this.height : this.height) - (p.isStart ? -p.height : p.height);
                }
            }
            return -1;
        }
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public List<int[]> getSkyline(int[][] buildings) {

        buildingPoint[] inputBuildings = new buildingPoint[buildings.length * 2];

        int index = 0;
        for(int[] building: buildings){
            buildingPoint building1 = new buildingPoint();
            building1.x = building[0];
            building1.height = building[2];
            building1.isStart = true;
            inputBuildings[index++] = building1;

            buildingPoint building2 = new buildingPoint();
            building2.x = building[1];
            building2.height = building[2];
            building2.isStart = false;
            inputBuildings[index++] = building2;
        }

        Arrays.sort(inputBuildings);
        map.put(0,1);

        int prevMax = 0;
        List<int[]> skyline = new ArrayList<>();

        for(buildingPoint crt_point : inputBuildings){
            if(crt_point.isStart){
                map.compute(crt_point.height, (k,v)->v == null ? 1 : v+1);
            }else{
                map.compute(crt_point.height, (k,v)->v == 1 ? null : v-1);
            }
            int crt_max_height = map.lastKey();
            if(prevMax != crt_max_height){
                skyline.add(new int[]{crt_point.x, crt_max_height});
                prevMax=crt_max_height;
            }
        }
        return skyline;
    }


    /***
     * Copied from Leetcode Discussion...Uses Priority Queue for solving the problem..
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline_UsingQueue(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for(int[] h:height) {
            if(h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        Skyline sd = new Skyline();
        List<int[]> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(Arrays.toString(cp)));
    }

}
