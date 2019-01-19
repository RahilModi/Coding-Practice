package com.programming.leetcode.Hard;

import com.programming.leetcode.Easy.NumberOfBoomerangs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Sorting takes O(nlogn)
 * Solve in O(N)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int max = 0;
        if(nums == null || nums.length == 0) return max;
        Set<Integer> numbers = new HashSet<>();

        for(int i : nums){
            numbers.add(i);
        }

        for(int i : nums){
            int pre = i - 1, next = i + 1;
            while(numbers.contains(pre)) --pre;
            while(numbers.contains(next)) ++next;

            max = Math.max(max, next - pre -1);
        }

        return max;
    }


    public int longestConsecutive_improved(int[] nums) {
        int max = 0;
        if(nums == null || nums.length == 0) return max;
        Set<Integer> numbers = new HashSet<>();

        for(int i : nums){
            numbers.add(i);
        }

        for(int i : numbers){

            //Iterate for next elements only and only if previous element is not present in the input set.
            //This is will stop redundant iterations
            //lets understand the case if set contains 1,2,3,4,100
            //so when i contains 3 so we will not check for next element is present or not because previous element 2 is in the set
            //so when it is turn for 2 we will check for 1 and it is also their so we will not go into if block
            //Now it is turn for 1 and 0 is not in the set so we will check how many consecutive next elements are their in the set using while inside the if and will give us crt_longest_seq

            if(!numbers.contains(i-1)){
                int crt_num = i;
                int crt_sequence_len = 1;
                while(numbers.contains(crt_num+1)){
                    crt_num += 1;
                    crt_sequence_len += 1;
                }
                max = Math.max(max,crt_sequence_len);
            }
        }

        return max;
    }

    public int longestConsecutive_using_hashtable(int[] nums) {
        int max = 0;
        if(nums == null || nums.length == 0) return max;
        Map<Integer,Integer> num_map = new HashMap<>();

        for(int i : nums){
            if(num_map.containsKey(i)) continue;
            int left =  num_map.containsKey(i-1) ? num_map.get(i-1) : 0;
            int right = num_map.containsKey(i+1) ? num_map.get(i+1) : 0;

            int sum = left + right + 1;
            num_map.put(i, sum);
            max = Math.max(sum, max);
            num_map.put(i - left, sum);
            num_map.put(i + right, sum);
        }

        return max;
    }

    public int longestConsecutive_union_find(int[] nums) {
        UF obj = new UF(nums.length);
        Map<Integer,Integer> map = new HashMap<>(); // <value,index>
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            Integer left = map.get(nums[i]-1);
            if(left != null){
                obj.union(i,left);
            }
            Integer right = map.get(nums[i]+1);
            if(right != null){
                obj.union(i,right);
            }
        }
        return obj.maxUnion();
    }

    class UF{
        private int[] list;
        private int[] size;

        public UF(int n){
            list = IntStream.range(0,n).toArray();
            size = new int[n];
            Arrays.fill(size,1);
        }

        private int root(int i){
            while(i!=list[i]){
                list[i] = list[list[i]];
                i = list[i];
            }
            return i;
        }

        public boolean connected(int i, int j){
            return root(i) == root(j);
        }

        public void union(int p, int q){
            int i = root(p);
            int j = root(q);
            if(size[i] < size[j]){
                list[i] = j ;
                size[j] += size[i];
            }else{
                list[j] = i;
                size[i] += size[j];
            }
        }

        // returns the maxium size of union useful for quick-union implementation
        public int maxUnion(){ // O(n)
//            int[] count = new int[list.length];
//            int max = 0;
//            for(int i=0; i<list.length; i++){
//                int root_val = root(i);
//                count[root_val]++;
//                max = Math.max(max, count[root_val]);
//            }
//            return max;

            return Arrays.stream(size).max().getAsInt();
        }

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive_using_hashtable(new int[]{1001,2,1,3,50,20,30,4,5}));
        System.out.println(obj.longestConsecutive_union_find(new int[]{1001,3,50,20,30,5}));
    }

}
