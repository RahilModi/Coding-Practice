package com.programming.leetcode.Medium;

public class SolveTheEquation {

    public String solveEquation(String equation) {
        String[] res= equation.split("=");
        int[] res1 = evaluateExpression(res[0]), res2 = evaluateExpression(res[1]);
        res1[0] -= res2[0];
        res2[1] -= res1[1];
        if(res1[0] == 0 && res2[1] == 0) return "Infinite solutions";
        if(res1[0] == 0 && res2[1] != 0) return "No solution";
        return "x="+(res2[1]/res1[0]);
    }

    private int[] evaluateExpression(String exp){
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2];
        for(String token : tokens){
            if(token.equals("+x") || token.equals("x")){
                res[0]++;
            }else if(token.equals("-x")){
                res[0]--;
            }else if(token.contains("x")){
                res[0] += Integer.valueOf(token.substring(0, token.indexOf('x')));
            }else{
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SolveTheEquation obj = new SolveTheEquation();
        System.out.println(obj.solveEquation("x=x"));
        System.out.println(obj.solveEquation("2x=x+2"));
        System.out.println(obj.solveEquation("x=x+2"));
        System.out.println(obj.solveEquation("x+5-3+x=6+x-2"));
    }
}
