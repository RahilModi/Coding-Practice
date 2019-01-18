package com.programming.GeeksForGeeks.coursera_algoritms.DisjointSets;


import java.util.stream.IntStream;

//known as lazy approach
public class QuickUnion {

    private int[] id;

    //Initialize O(N)
    public QuickUnion(int N) {
        if (N < 0) throw new IllegalArgumentException();
        this.id = IntStream.range(0, N).toArray();
    }

    //worst case...O(N)
    private int root(int index){
        while(index != this.id[index]) index = this.id[index];
        return index;
    }

    // [0, 1, 2, 3, 4] => union(0,1) => [1, 1, 2, 3, 4]
    public void union(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        int root_of_p = root(p);
        int root_of_q = root(q);

        this.id[root_of_p] = root_of_q;
    }

    //O(N)
    public boolean connected(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        return root(p) == root(q);
    }
}
