package com.programming.leetcode.Hard;

import java.util.*;

public class CutOffTreesForGolfEvent {

    int[][] dir = new int[][] { {0,1},{1,0},{0,-1},{-1,0}};
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.get(0).isEmpty()) return 0;
        if(forest.get(0).get(0) == 0) return -1;
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j)>1)
                    queue.offer(new int[]{i,j,forest.get(i).get(j)});
            }
        }
        int start[] = new int[2];
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] tree = queue.poll();
            int step = helper(forest.size(),forest.get(0).size(), start, tree, forest);
            if (step < 0) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }

    public int helper(int numRow, int numCol, int[] start, int[] tree, List<List<Integer>> input){
        int step = 0;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited.add(start[0]+"-"+start[1]);
        while(!q.isEmpty()){
            int crt_size = q.size();
            for(int i = 0; i < crt_size; i++){
                int[] crt = q.poll();
                if(crt[0] == tree[0] && crt[1]== tree[1]) return step;
                for(int[] d : dir){
                    int nRow = crt[0]+d[0];
                    int nCol = crt[1]+d[1];
                    if(nRow < 0 || nCol < 0 || nRow >= numRow || nCol >= numCol ||
                        input.get(nRow).get(nCol) == 0||visited.contains(nRow+"-"+nCol)) continue;
                    q.offer(new int[]{nRow,nCol});
                    visited.add(nRow+"-"+nCol);
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(Arrays.asList(new Integer[]{1,2,3}));
        test.add(Arrays.asList(new Integer[]{0,0,4}));
        test.add(Arrays.asList(new Integer[]{7,6,5}));
        new CutOffTreesForGolfEvent().cutOffTree(test);
    }
}
