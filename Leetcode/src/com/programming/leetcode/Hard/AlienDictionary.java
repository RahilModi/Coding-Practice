package com.programming.leetcode.Hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return null;
        if(words.length == 1) return words[0];

        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        for(int i = 0; i < words.length -1; i++) {
            boolean found = false;
            String w1 = words[i], w2 = words[i+1];
            for (int j = 0; j < Math.max(words[i].length(), words[i+1].length()); j++){
                Character c1 = j < w1.length() ? w1.charAt(j) : null;
                Character c2 = j < w2.length() ? w2.charAt(j) : null;
                if(c1 != null && !adjacencyList.containsKey(c1)){
                    adjacencyList.put(c1, new ArrayList<>());
                }
                if(c2 != null && !adjacencyList.containsKey(c2)){
                    adjacencyList.put(c2, new ArrayList<>());
                }
                if(c1 != null && c2 != null && c1 != c2 && !found){
                    adjacencyList.get(c1).add(c2);
                    found = true;
                }
            }
        }

        boolean[] visited = new boolean[26];
        Stack<Character> seq = new Stack<>();
        Set<Character> loop = new HashSet<>();
        for(Character c : adjacencyList.keySet()){
            if(!visited[c-'a']){
                if(!topological_sort(adjacencyList,visited,seq,loop,c)){
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!seq.isEmpty()) sb.append(seq.pop());
        return sb.toString();
    }


    boolean topological_sort(Map<Character, List<Character>> adjList, boolean[] visited, Stack<Character> seq, Set<Character> loop, char c){
        visited[c-'a'] = true;
        loop.add(c);
        if(adjList.containsKey(c)){
            for(int k = 0 ; k < adjList.get(c).size(); k++){
                char t = adjList.get(c).get(k);
                if(loop.contains(t))return false;
                if(!visited[t-'a']){
                    if(!topological_sort(adjList,visited,seq,loop,t)){
                        return false;
                    }
                }
            }
        }
        loop.remove(c);
        seq.add(c);
        return true;
    }


    /***
     *
     * Using BFS algorithms...
     *
     */

    class Pair{

        char first;
        char Second;

        public Pair(char first, char second) {
            this.first = first;
            Second = second;
        }

        public char getFirst() {
            return first;
        }

        public void setFirst(char first) {
            this.first = first;
        }

        public char getSecond() {
            return Second;
        }

        public void setSecond(char second) {
            Second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(Second, pair.Second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, Second);
        }
    }

    public String alienOrderUsingBFS(String[] words) {
        StringBuilder sb = new StringBuilder();
        if(words == null || words.length == 0) return null;
        int[] inDegree = new int[256];
        if(words.length == 1) return words[0];
        Set<Pair> pairSet = new HashSet<>();
        Set<Character> charSet = Stream.of(words)
                                    .map(CharSequence::chars)
                                    .flatMap(c-> c.mapToObj(y->(char)y))
                                    .collect(Collectors.toSet());
        Queue<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < words.length -1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int mn = Math.min(w1.length(), w2.length());
            int j = 0;
            for(; j < mn; j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    pairSet.add(new Pair(w1.charAt(j), w2.charAt(j)));
                    break;
                }
            }
            if(j == mn && w1.length() > w2.length()) return sb.toString();
        }
        for(Pair pair : pairSet){
            ++inDegree[pair.Second];
        }

        for(Character c: charSet){
            if(inDegree[c]==0){
                queue.add(c);
                sb.append(c);
            }
        }

        while(!queue.isEmpty()){
            char c = queue.poll();
            for(Pair pair : pairSet){
                if(pair.first == c) {
                    --inDegree[pair.Second];
                    if (inDegree[pair.Second] == 0) {
                        queue.add(pair.Second);
                        sb.append(pair.Second);
                    }
                }
            }
        }
        return sb.length() == charSet.size() ? sb.toString() : "";

    }

    /***
     * Using DFS...
     * @param
     */
    public String alienOrderUsingDFS(String[] words) {
        StringBuilder sb = new StringBuilder();
        if(words == null || words.length == 0) return null;
        boolean[][] charpairs = new boolean[26][26];
        boolean[] visited = new boolean[26];
        if(words.length == 1) return words[0];
        Stream.of(words)
                .map(CharSequence::chars)
                .flatMap(c-> c.mapToObj(y->(char)y))
                .forEach(c -> charpairs[c-'a'][c-'a']=true);
        for(int i = 0; i < words.length -1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int mn = Math.min(w1.length(), w2.length());
            int j = 0;
            for(; j < mn; j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    charpairs[c1-'a'][c2-'a']=true;
                    break;
                }
            }
            if(j == mn && w1.length() > w2.length()) return sb.toString();
        }
        for(int i = 0; i < 26; i++){
            if(!dfs(charpairs,visited,sb,i)) return "";
        }
        return sb.toString();
    }

    public boolean dfs(boolean[][] chairPairs, boolean[] visited, StringBuilder sb, int idx){
        if(!chairPairs[idx][idx]) return true;
        visited[idx] = true;
        for(int i = 0; i < 26; i++){
            if(i == idx || !chairPairs[i][idx]) continue;
            if(visited[i]) return false;
            if(!dfs(chairPairs,visited,sb,i)) return false;
        }
        visited[idx] = false;
        chairPairs[idx][idx] = false;
        sb.append((char)(idx+'a'));
        return true;
    }



    public static void main(String[] args) {

        System.out.println(new AlienDictionary().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new AlienDictionary().alienOrderUsingBFS(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new AlienDictionary().alienOrderUsingDFS(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
