package com.programming.leetcode.Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCards {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<deck.length; i++){
            deque.offer(i);
        }

        int[] res = new int[deck.length];
        Arrays.sort(deck);
        for(int card : deck){
            res[deque.poll()] = card;
            if(!deque.isEmpty()){
                deque.add(deque.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RevealCards rc = new RevealCards();
        rc.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
    }


}
