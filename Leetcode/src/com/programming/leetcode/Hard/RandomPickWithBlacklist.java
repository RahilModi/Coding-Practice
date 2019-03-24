package com.programming.leetcode.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//https://leetcode.com/problems/random-pick-with-blacklist/discuss/144624/Java-O(B)-O(1)-HashMap
//O(B)
public class RandomPickWithBlacklist {

    private int M;
    private Random random;
    private Map<Integer, Integer> mapBlackList;
    public RandomPickWithBlacklist(int N, int[] blacklist) {
        mapBlackList = new HashMap<>();
        random = new Random();
        for(int b : blacklist){
            mapBlackList.put(b, -1);
        }
        M = N-mapBlackList.size();
        for(int b : blacklist){
            if(b < M){ //remapping
                while (mapBlackList.containsKey(N-1)) N--;
                mapBlackList.put(b, --N);
            }
        }
    }

    public int pick() {
        int crtPick = random.nextInt(M);
        return mapBlackList.getOrDefault(crtPick, crtPick);
    }

}
