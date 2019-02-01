package com.programming.leetcode.Medium;

public class EscapeGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distanceToTarget = Math.abs(target[0]) +Math.abs(target[1]);
        for(int[] ghostLoc : ghosts){
            int ghostToTargetDist = Math.abs(ghostLoc[0]-target[0]) + Math.abs(ghostLoc[1]-target[1]);
            if(ghostToTargetDist <= distanceToTarget) return false;
        }
        return true;
    }

}
