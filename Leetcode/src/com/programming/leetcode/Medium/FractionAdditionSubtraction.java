package com.programming.leetcode.Medium;

public class FractionAdditionSubtraction {

    public String fractionAddition(String expression) {
        String[] tokens = expression.split("(?=[-+])");
        int numerators[] = new int[tokens.length];
        int denominator[] = new int[tokens.length];
        int id = 0;
        int lcm = 0;
        for (String token : tokens) {
            String[] t = token.split("/");
            numerators[id] = Integer.parseInt(t[0]);
            denominator[id] = Integer.parseInt(t[1]);
            lcm = (lcm == 0) ? denominator[id] : getLCM(lcm, denominator[id]);
            id++;
        }
        int sum = 0;
        for(int i = 0; i < tokens.length; i++){
            numerators[i] *= lcm/denominator[i];
            sum += numerators[i];
        }
        int gcd = generategcd(sum, lcm);
        if(gcd != 0) {
            sum /= gcd;
            lcm /= gcd;
            if(lcm < 0) {
                sum *= -1;
                lcm *= -1;
            }
        }
        return ""+sum+"/"+lcm;
    }

    private int getLCM(int a, int b){
        return (a*b)/generategcd(a,b);
    }
    private int generategcd(int a, int b){
        if(b == 0) return a;
        return generategcd(b, a%b);
    }

    public static void main(String[] args) {
        FractionAdditionSubtraction obj = new FractionAdditionSubtraction();
        System.out.println(obj.fractionAddition("1/2-4/1-4/3+1/2-5/1"));
    }
}
