package com.programming.leetcode.Medium;

import org.omg.PortableInterceptor.INACTIVE;
import sun.awt.datatransfer.DataTransferer;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class TopKElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numCountSortedByValue = new HashMap<>();
        for(int i : nums){
            numCountSortedByValue.put(i, numCountSortedByValue.getOrDefault(i,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(numCountSortedByValue.entrySet());
        list.sort(comparingByValue(Comparator.reverseOrder()));
        //Collections.reverse(list); => if not used Comparator.reverseOrder();

        //Method2 => Lambda

        /*numCountSortedByValue.entrySet().stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));*/


        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, Integer> elem : list){
           if(k == 0){
               break;
           }
           result.add(elem.getKey());
           k--;
        }

        return result;

    }

    public static Map<Integer,Integer> sortedByValue(Map<Integer,Integer> inputMap){
        Comparator<Map.Entry<Integer,Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        };

        Map<Integer,Integer> sortedMap = new TreeMap(valueComparator);
        sortedMap.putAll(inputMap);

        return sortedMap;
    }

    public static class valueComparator implements Comparator{

        Map<Integer,Integer> map;
        public valueComparator(Map<Integer,Integer> inputmap){
            map = inputmap;
        }

        @Override
        public int compare(Object o1, Object o2) {
            if(this.map.get(o1) >= this.map.get(o2)) return -1;
            else return 1;
        }
    }

    public List<Integer> topKFrequentV2(int[] nums, int k) {

        Map<Integer, Integer> numCount = new HashMap<>();
        for(int i : nums){
            numCount.put(i, numCount.getOrDefault(i,0)+1);
        }

        valueComparator comp = new valueComparator(numCount);

        Map<Integer, Integer> sortedByValueReverse = new TreeMap<>(comp);
        sortedByValueReverse.putAll(numCount);

        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer, Integer> elem : sortedByValueReverse.entrySet()){
            if(k == 0){
                break;
            }
            result.add(elem.getKey());
            k--;
        }

        return result;

    }

    //Bucket Sort

    public List<Integer> topKFrequencyUsingBucketSort(int[] nums, int k) {

        Map<Integer, Integer> numCount = new HashMap<>();
        for(int i : nums){
            numCount.put(i, numCount.getOrDefault(i,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length];

        for(Map.Entry <Integer,Integer> entry : numCount.entrySet()){
            if(buckets[entry.getValue()-1] == null) buckets[entry.getValue()-1] = new ArrayList<>();
            buckets[entry.getValue()-1].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length -1; i>=0 && k > 0 ; i--){
            if(buckets[i] == null) continue;
            else{
                for(int j = buckets[i].size(), index = 0; j > 0 && k > 0; j--, k--){
                    if(k > 0){
                        result.add(buckets[i].get(index++));
                    }
                }
            }
        }
        return result;

    }

    public List<Integer> topKFrequencyTreeMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }


    public List<Integer> topKFrequentUsingMaxHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        maxHeap.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> topK = new TopKElements().topKFrequent(new int[]{1,1,1,1,2,3,4,4}, 2);
        for(Integer i : topK) System.out.println(i);

        List<Integer> topK2 = new TopKElements().topKFrequentV2(new int[]{1,1,1,1,2,3,4,4}, 2);
        for(Integer i : topK2) System.out.println(i);

        List<Integer> topK3 = new TopKElements().topKFrequencyUsingBucketSort(new int[]{1,1,1,1,2,3,4,4}, 2);
        for(Integer i : topK3) System.out.println(i);
    }

}
