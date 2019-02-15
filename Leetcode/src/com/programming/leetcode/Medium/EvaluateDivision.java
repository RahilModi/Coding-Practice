package com.programming.leetcode.Medium;

import java.util.*;

public class EvaluateDivision {

    static class term{
        String divisor;
        double dividend;

        public term(String divisor, double dividend) {
            this.divisor = divisor;
            this.dividend = dividend;
        }
    }

    Map<String, List<term>> equationMap = new HashMap<>();
    double ans = 1.0;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; i++) {
            equationMap.computeIfAbsent(equations[i][0], k -> new ArrayList<>()).add(new term(equations[i][1], values[i]));
            equationMap.computeIfAbsent(equations[i][1], k -> new ArrayList<>()).add(new term(equations[i][0], 1 / values[i]));
        }
        double[] res = new double[queries.length];
        int id = 0;
        for (String[] query : queries) {
            if (query[0].equals(query[1]) && equationMap.containsKey(query[0])) res[id] = 1.0;
            else if (query[0].equals(query[1]) && !equationMap.containsKey(query[0])) res[id] = -1.0;
            else if(!equationMap.containsKey(query[0])||!equationMap.containsKey(query[1])) res[id] = -1.0;
            else {
                Set<String> seen = new HashSet<>();
                boolean notFound = false;
                for (int i = 0; i < equationMap.get(query[0]).size(); i++) {
                    seen.add(query[0]);
                    term crt = equationMap.get(query[0]).get(i);
                    if (crt.divisor.equals(query[1])) {
                        res[id] = crt.dividend;
                        notFound = true;
                        break;
                    } else{
                        if(helper(query[1], crt.dividend, seen, crt.divisor)) {
                            res[id] = ans;
                            ans = 1;
                            notFound = true;
                            break;
                        }
                    }
                }
                if(!notFound){
                    res[id] = -1.0;
                }
            }
            id++;
        }
        return res;
    }

    public boolean helper(String target, double val, Set<String> seen, String crt){
        if(target.equals(crt)){
            ans *= val;
            return true;
        }
        seen.add(crt);
        for (int i = 0; i < equationMap.get(crt).size(); i++){
            term c = equationMap.get(crt).get(i);
            if(!seen.contains(c.divisor)){
                if(helper(target, c.dividend, seen, c.divisor)){
                    ans *= val;
                    return true;
                }
            }
        }
        seen.remove(crt);
        return false;
    }

    public static void main(String[] args) {
        EvaluateDivision obj = new EvaluateDivision();
        System.out.println(Arrays.toString(obj.calcEquation(new String[][]{{"a", "b"},{"b", "c"}},new double[]{2.0,3.0}, new String[][]{{"a", "c"},{"b","c"},{"a","e"}})));
    }
}
