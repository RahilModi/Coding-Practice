package com.programming.leetcode.Medium;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        int numMoves = 0;
        String start = "0000";
        if(target.equals(start)) return 0;
        Set<String> blacklisted = new HashSet<>(Arrays.asList(deadends));
        if(blacklisted.contains(start) || blacklisted.contains(target)) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                String crtState = queue.poll();
                if(crtState.equals(target)) return numMoves;
                for(int j = 0; j < crtState.length(); j++){
                    char t = crtState.charAt(j);
                    for(int k : new int[]{1,-1}) {
                        String newState = crtState.substring(0, j) + (t-'0' + k + 10)%10 + crtState.substring(j + 1);
                        if (blacklisted.contains(newState) || seen.contains(newState)) continue;
                        queue.offer(newState);
                        seen.add(newState);
                    }
                }
            }
            numMoves++;
        }
        return -1;
    }


    //2-end processing...better runtime..
    //https://leetcode.com/problems/open-the-lock/discuss/110237/Regular-java-BFS-solution-and-2-end-BFS-solution-with-improvement
    public int openLockV1(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        while(!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = end;
            end = temp;
        }
        return -1;
    }

    public static void main(String[] args) {

        class Inner{
            final int i6 = 6;
            int i7 = 7;
            Inner(){
                System.out.println(i6+i7);
            }
        }

        boolean b1 = true, b2 = false, b3 = false;
        if(b1 & b2 | b2 & b3 | b2) System.out.println("okay");
        System.out.println(3&5);
        OpenTheLock obj = new OpenTheLock();
        List<Integer>a= new ArrayList<>();
        a.add(1);
        a.add(4);
        List<Integer> b = obj.dostuff(a);
        b.add(5);
        System.out.println(a);
        System.out.println(obj.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(obj.openLockV1(new String[]{"0201","0101","0102","1212","2002"}, "0202"));

        System.out.println(obj.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
        System.out.println(obj.openLock(new String[]{"8888"}, "0009"));
    }


    private List<Integer> dostuff(List<Integer> x){
        x.add(1);
        return x;
    }

}
