package com.programming.GeeksForGeeks.Misc;

import java.util.Arrays;

/***
 * Known as Binary Indexed Tree or Fenwick Tree..
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 *
 * References
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * http://en.wikipedia.org/wiki/Fenwick_tree
 * Binary Indexed Trees (BIT or Fenwick tree):
 * https://www.topcoder.com/community/data-science/data-science-
 * tutorials/binary-indexed-trees/
 *
 * Example: given an array a[0]...a[7], we use a array BIT[9] to
 * represent a tree, where index [2] is the parent of [1] and [3], [6]
 * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
 * [8] is the parent of [4]. I.e.,
 *
 * BIT[] as a binary tree:
 *            ______________*
 *            ______*
 *            __*     __*
 *            *   *   *   *
 * indices: 0 1 2 3 4 5 6 7 8
 *
 * BIT[i] = ([i] is a left child) ? the partial sum from its left most
 * descendant to itself : the partial sum from its parent (exclusive) to
 * itself. (check the range of "__").
 *
 * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
 * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
 * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
 * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
 *
 * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
 * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
 * last 1-bit from [i].
 *
 * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
 * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
 * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
 *
 * To obtain the original value of a[7] (corresponding to index [8] of
 * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
 * starting from [idx-1], for current [i], the next subtrahend [j] is
 * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
 * way but using extra space is to store the original array.)
 */
public class FenwickTree {

    private int[] binaryIndexedTree;
    private int[] nums;

    /***
     * Create a binary indexed tree...
     * @param input
     */
    public FenwickTree(int[] input) {
        this.nums = input;
        this.binaryIndexedTree = new int[input.length+1];
        for(int i = 0; i < input.length; i++){
            init(i, input[i]);
        }
    }

    /***
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     *
     * @param crt_index
     * @return
     */
    public int getIndex(int crt_index){
        return crt_index + (crt_index & -crt_index);
    }


    /***
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     *
     * @param crt_index
     * @return
     */
    public int getParent(int crt_index){
        return crt_index - (crt_index & -crt_index);
    }

    public void init(int index, int val){
        index++;
        while(index < this.binaryIndexedTree.length){
            this.binaryIndexedTree[index] += val;
            index = getIndex(index);
        }
    }

    /***
     * Update the value at given index
     * @param index
     * @param val
     */
    public void update(int index, int val){
        int diff = val - this.nums[index];
        this.nums[index] = val;
        init(index, diff);
    }

    /***
     * use will return the sum for the elements starting from index 0 to the requested index..
     * @param index
     * @return
     */
    public int getSum (int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += this.binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    /***
     * find the sum from 0 to endIndex and sum from 0 to start_index -1 and take the difference of both...
     * @param start_index
     * @param end_index
     * @return
     */
    public int getSumRange(int start_index, int end_index){
        return getSum(end_index) - getSum(start_index-1);
    }


    private void printBinaryIndexedTree(){
        System.out.println(Arrays.toString(this.binaryIndexedTree));
    }

    public static void main(String[] args) {
         FenwickTree numArray = new FenwickTree(new int[]{1,2,4,2,5,29});
         numArray.printBinaryIndexedTree();
        System.out.println(numArray.getSumRange(0, 1));
         numArray.printBinaryIndexedTree();
         numArray.update(1, 10);
         numArray.printBinaryIndexedTree();
        System.out.println(numArray.getSumRange(1, 2));
         numArray.printBinaryIndexedTree();
    }
}
