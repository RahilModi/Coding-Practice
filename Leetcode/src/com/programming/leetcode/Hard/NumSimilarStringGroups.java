package com.programming.leetcode.Hard;

public class NumSimilarStringGroups {

    public int numSimilarGroups(String[] A) {
        if(A.length < 2)return A.length;
        int numGroups = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == null) continue;
            String temp = A[i];
            A[i] = null;
            dfs(A, temp);
            numGroups++;
        }
        return numGroups;
    }

    private void dfs(String[] A, String crt){
        for(int i = 0; i < A.length ; i++){
            if(A[i] == null) continue;
            if(isSimilar(crt, A[i])){
                String s = A[i];
                A[i] = null;
                dfs(A,s);
            }
        }
    }

    private boolean isSimilar(String a, String b){
        int diff = 0, i = 0;
        while(i < a.length() && diff <= 2){
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            i++;
        }
        return diff <= 2;
    }

    public static void main(String[] args) {
        String arr[] = {"tars","rats","arts","star"};
        NumSimilarStringGroups obj = new NumSimilarStringGroups();
        System.out.println(obj.numSimilarGroups(arr));
    }
}
