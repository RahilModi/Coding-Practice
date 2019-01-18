package com.programming.GeeksForGeeks.coursera_algoritms.DisjointSets;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PathCompressionQuickUnion {

    private int id[];
    private int num_components;
    int size[];

    public PathCompressionQuickUnion(int N) {
        if (N < 0) throw new IllegalArgumentException();
        this.id = IntStream.range(0,N).toArray();
        this.size = new int[N];
        Arrays.fill(this.size, 1);
        this.num_components = N;
    }

    private int root(int index){
        while (index != this.id[index]){
            this.id[index] = this.id[this.id[index]];
            index = this.id[index];
        }
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
        this.num_components--;
        ValidationUtil.printInputArray(this.id);
    }

    public boolean connected(int p, int q){
        ValidationUtil.isValidInput(p, id.length);
        ValidationUtil.isValidInput(q,id.length);
        return root(p) == root(q);
    }

    public static void main(String[] args) {

        PathCompressionQuickUnion obj = new PathCompressionQuickUnion(10);
        obj.union(0,1);
        obj.union(1,3);
        obj.union(7,2);
        obj.union(3,5);
        obj.union(8,4);
        obj.union(2,8);
        obj.union(0, 9);

    }
}
