package com.programming.GeeksForGeeks.Misc;

public class SegmentTree {

    /**
     * LIke Heap -> 2i+1 is the left child, 2i+2 is the right child and i-1 /2 is parent
     *
     */
    int[] segmentTree;

    public void createSegmentTree(int [] input) {
        int height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
        segmentTree = new int[(int) (Math.pow(2, height + 1) - 1)];
        constructTree(input, 0, input.length - 1, 0);
    }

    private void constructTree(int input[], int low, int high, int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high)/2;
        constructTree(input,low,mid,2*pos+1);
        constructTree(input,mid+1,high,2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
    }

    private int rangeMinQuery(int low,int high,int qlow,int qhigh,int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low+high)/2;
        return Math.min(rangeMinQuery(low,mid,qlow,qhigh,2*pos+1),
                rangeMinQuery(mid+1,high,qlow,qhigh,2*pos+2));
    }

    public static void main(String[] args) {
        SegmentTree sm = new SegmentTree();
        sm.createSegmentTree(new int[]{3,4,2,1,6,-1});
        System.out.println(sm.rangeMinQuery(0,5,1,5,0));
    }

}
