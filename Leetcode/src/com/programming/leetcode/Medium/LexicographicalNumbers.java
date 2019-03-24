package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++) dfs(i, res, n);
        return res;
    }

    private void dfs(int crt, List<Integer> list, int limit){
        if(crt > limit) return;
        else{
            list.add(crt);
            for(int i = 0; i < 10 && 10*crt+i <= limit; i++){
                dfs(10*crt+ i, list, limit);
            }
        }
    }

    public List<Integer> lexicalOrderV1(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LexicographicalNumbers obj = new LexicographicalNumbers();
        System.out.println(obj.lexicalOrderV1(13));
        System.out.println(obj.lexicalOrder(13));
        System.out.println(obj.lexicalOrder(100));
    }

}
