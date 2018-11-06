package com.programming.leetcode.Medium;

import java.util.stream.Stream;

public class ComplexNumberMultiplication {

    //(a+bi) * (c+di) => ac + bdi^2 + adi + bci => (ac - bd) + (ad + bc)i
    public String complexNumberMultiply(String a, String b) {
        int[] coeffOfA = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        int[] coeffOfB = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        StringBuilder strBld = new StringBuilder();
        strBld.append(coeffOfA[0]*coeffOfB[0] - coeffOfA[1]*coeffOfB[1]);
        strBld.append('+');
        strBld.append(coeffOfA[0]*coeffOfB[1] + coeffOfA[1]*coeffOfB[0]);
        strBld.append('i');
        return strBld.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+2i","3+4i"));
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+1i","1+1i"));
    }
}
