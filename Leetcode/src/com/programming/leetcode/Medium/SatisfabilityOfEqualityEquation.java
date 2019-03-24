package com.programming.leetcode.Medium;

public class SatisfabilityOfEqualityEquation {

    class DSU{
        private int[] letters;
        DSU(){
            letters = new int[26];
            for(int i = 0; i < letters.length; i++) letters[i] = i;
        }

        void union(int a, int b){
            a = find(a);
            b = find(b);
            if(a!=b) letters[a] = b;
        }

        int find(int x){
            if(x == letters[x]) return x;
            letters[x] = find(letters[x]);
            return letters[x];
        }
    }

    public boolean equationsPossible(String[] equations) {
        DSU uf = new DSU();
        for(String eq : equations) {
            if(eq.charAt(1) == '='){
                uf.union(eq.charAt(0)-'a',eq.charAt(3)-'a');
            }
        }
        for(String eq : equations){
            if(eq.charAt(1) == '!' && uf.find(eq.charAt(0)-'a') == uf.find(eq.charAt(3)-'a')) return false;
        }
        return true;
    }

}
