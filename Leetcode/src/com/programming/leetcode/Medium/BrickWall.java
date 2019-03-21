package com.programming.leetcode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        //calculate possible length of walls from given row and increment the count if already possible by others
        //Take the max Count and subtract from the wall size to get the min answer
        Map<Integer, Integer> wallLengthMap = new HashMap<>();
        int maxCountOfSameLength = 0, length;
        for(List<Integer> list : wall){
            length = 0;
            for(int i = 0; i < list.size()-1; i++){
                length += list.get(i);
                wallLengthMap.put(length, wallLengthMap.getOrDefault(length, 0)+1);
                maxCountOfSameLength = Math.max(maxCountOfSameLength, wallLengthMap.get(length));
            }
        }
        return wall.size() - maxCountOfSameLength;
    }

    //Very similar approach of smallest range problem
    //https://leetcode.com/problems/brick-wall/discuss/101794/Verbose-Java-Solution-PriorityQueue
    public int leastBricksV1(List<List<Integer>> wall) {
        int R = wall.size(), min = R,crtEnd, count;
        if (R == 1 && wall.get(0).size() > 1) return 0;
        // [0: end, 1: row, 2: col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        //Add 1st element of each row...
        for (int i = 0; i < R; i++) {
            pq.add(new int[] {wall.get(i).get(0), i, 0});
        }
        while (!pq.isEmpty()) {
            crtEnd = pq.peek()[0];
            count = 0;
            while (!pq.isEmpty() && pq.peek()[0] == crtEnd) {
                count++;
                int[] brick = pq.poll();
                if (brick[2] < wall.get(brick[1]).size() - 1) {
                    pq.add(new int[] {crtEnd + wall.get(brick[1]).get(brick[2] + 1), brick[1], brick[2] + 1});
                }
            }
            if (!pq.isEmpty()) {
                min = Math.min(min, R - count);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.stream(new int[]{1,2,2,1}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{3,1,2}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{1,3,2}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{2,4}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{3,1,2}).boxed().collect(Collectors.toList()));
        input.add(Arrays.stream(new int[]{1,3,1,1}).boxed().collect(Collectors.toList()));
        BrickWall obj = new BrickWall();
        System.out.println(obj.leastBricks(input));
    }

}
