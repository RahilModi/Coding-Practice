package com.programming.GeeksForGeeks.coursera_algoritms.DisjointSets;

import java.util.stream.IntStream;


//Union Operation is too expensive...
public class QuickFind {

    private int[] id;

    //Initialize O(N)
    public QuickFind(int N) {
        if (N < 0) throw new IllegalArgumentException();
        this.id = IntStream.range(0,N).toArray();
    }

    //O(N)
    public void union(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        int pId = this.id[p];
        int qId = this.id[q];
        for(int i = 0 ;i < this.id.length;i++) {
            if (this.id[i] == pId) this.id[i] = qId;
        }
    }

    //O(1)
    public boolean connected(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        return this.id[p]==this.id[q];
    }

}
