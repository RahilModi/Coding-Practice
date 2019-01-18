package com.programming.GeeksForGeeks.coursera_algoritms.DisjointSets;

import java.util.Arrays;
import java.util.stream.IntStream;


//Uses the height of Tree to identify the union operation
//Other alternative is uses size( number of nodes ) in the tree..
public class weighted_quick_union {

    int size[];
    int id[];

    public weighted_quick_union(int N) {
        if (N < 0) throw new IllegalArgumentException();
        this.size = new int[N];
        Arrays.fill(this.size, 1);
        this.id = IntStream.range(0,N).toArray();
    }

    private int root(int index){
        while(index != this.id[index]) index = this.id[index];
        return index;
    }

    //O(log N)
    public void union(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        int root_of_p = root(p);
        int root_of_q = root(q);
        if (root_of_p == root_of_q) return;
        if(size[root_of_p] < size[root_of_q]){
            this.id[root_of_p] = root_of_q;
            size[root_of_q] += size[root_of_p];
        }else{
            this.id[root_of_q] = root_of_p;
            size[root_of_p] += size[root_of_q];
        }
    }

    public boolean connected(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        return root(p) == root(q);
    }
}
