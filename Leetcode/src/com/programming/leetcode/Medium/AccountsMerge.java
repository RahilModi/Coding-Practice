package com.programming.leetcode.Medium;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String,String> mapilToName = new HashMap<>();
        for(List<String> account : accounts){
            for(int i = 1; i < account.size(); i++){
                graph.computeIfAbsent(account.get(i), k -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), k->new ArrayList<>()).add(account.get(i));
                mapilToName.put(account.get(i), account.get(0));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email : graph.keySet()){
            if(!visited.contains(email)){
                visited.add(email);
                Queue<String> queue = new LinkedList<>();
                queue.offer(email);
                List<String> crt = new ArrayList<>();
                while (!queue.isEmpty()){
                    String crtEmail = queue.poll();
                    crt.add(crtEmail);
                    for(String em : graph.get(crtEmail)){
                        if(!visited.contains(em)){
                            queue.offer(em);
                            visited.add(em);
                        }
                    }
                }
                Collections.sort(crt);
                crt.add(0, mapilToName.get(email));
                res.add(crt);
            }
        }
        return res;
    }


    class DisjoinSet{
        int[]parent;
        DisjoinSet(){
            parent = new int[10001];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
        }
        public void union(int i, int j){
            int parentI = find(i);
            int parentJ = find(j);
            parent[parentI] = parentJ;
        }

        public int find(int i){
            parent[i] = parent[i] == i ? i : find(parent[i]);
            return parent[i];
        }
    }

    public List<List<String>> accountsMergeV1(List<List<String>> accounts) {
        DisjoinSet obj = new DisjoinSet();
        Map<String, Integer> emailToID = new HashMap<>();
        Map<String, String> mapilToName = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!emailToID.containsKey(account.get(i))) {
                    emailToID.put(account.get(i), id++);
                }
                obj.union(emailToID.get(account.get(1)), emailToID.get(account.get(i)));
                mapilToName.put(account.get(i), account.get(0));
            }
        }

        Map<Integer, List<String>> res = new HashMap<>();
        for(String email : emailToID.keySet()){
            int parent = obj.find(emailToID.get(email));
            res.computeIfAbsent(parent, k->new ArrayList<>()).add(email);
        }
        for (List<String> component: res.values()) {
            Collections.sort(component);
            component.add(0, mapilToName.get(component.get(0)));
        }
        return new ArrayList(res.values());
    }
}
