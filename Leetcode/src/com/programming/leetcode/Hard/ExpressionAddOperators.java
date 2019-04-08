package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {

        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        backtrack(num, 0, 0, "", res, target, 0);
        return res;

    }

    //O(4^N)
    private void backtrack(String num, int index, long eval, String path, List<String> res, int target, long prev){
        if(index == num.length()) {
            if(target == eval)
                res.add(path);
            return;
        }
        for(int i = index; i < num.length(); i++){
            if(i != index && num.charAt(index) == '0') break;
            Long crt = Long.valueOf(num.substring(index, i+1));
            if(index == 0){
                backtrack(num, i+1, eval+crt, path+crt, res, target , crt);
            }else{
                backtrack(num, i+1, eval+crt, path +"+"+crt, res, target, crt);

                backtrack(num, i+1, eval-crt, path +"-"+crt, res, target, -crt);

                backtrack(num, i+1, eval-prev + prev * crt, path +"*"+crt, res, target, prev * crt);
            }
        }
    }

}
