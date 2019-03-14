package com.programming.leetcode.Medium;

public class Flatten2DVector {

    int crtRow, crtCol, totalElements, count;
    int[][] vector;
    public Flatten2DVector(int[][] v) {
        vector = v;
        crtRow = crtCol = count = 0;
        for(int[] v1 : v){
            totalElements += v1.length;
        }
    }

    public int next() {
        while(crtCol >= vector[crtRow].length){
            crtCol = 0;
            crtRow++;
        }
        count++;
        return vector[crtRow][crtCol++];
    }

    public boolean hasNext() {
        return totalElements - count > 0;
    }

    public static void main(String[] args) {
        Flatten2DVector obj = new Flatten2DVector(new int[][]{{1,2},{},{3,4},{5},{8}});
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
