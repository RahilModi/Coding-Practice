package com.programming.leetcode.Medium;

import java.util.TreeSet;

public class ExamRoom {

    int num_seats;
    TreeSet<Integer> sorted_seats = new TreeSet<>((a,b)->a-b);

    public ExamRoom(int N) {
        num_seats = N;
    }

    public int seat() {
        int pos = 0;
        int max_dist = Integer.MIN_VALUE;

        if(!sorted_seats.isEmpty()){
            if(sorted_seats.first() != 0 && sorted_seats.first() > max_dist){
                max_dist = sorted_seats.first();
                pos = 0;
            }

            int prev = -1;
            for(int ocupied_seat : sorted_seats){
                if(prev != -1){
                    int crt_dist = (ocupied_seat - prev) / 2;
                    if(crt_dist > max_dist){
                        max_dist = crt_dist;
                        pos = prev + crt_dist;
                    }
                }
                prev = ocupied_seat;
            }

            if(sorted_seats.last() != num_seats -1 && num_seats - 1 - sorted_seats.last()  > max_dist){
                pos = num_seats-1;
            }
        }
        sorted_seats.add(pos);
        return pos;
    }

    public void leave(int p) {
        sorted_seats.remove(p);
    }
}
