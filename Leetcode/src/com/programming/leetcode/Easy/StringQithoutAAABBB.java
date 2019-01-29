package com.programming.leetcode.Easy;

public class StringQithoutAAABBB {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(A+B > 0){
            if(index > 1 && sb.charAt(index-1) == sb.charAt(index-2)){
                if(sb.charAt(index-1)=='a'){
                    sb.append('b');
                    B--;
                }else{
                    sb.append('a');
                    A--;
                }
            }
            else {
                if(A > B){
                    sb.append('a');
                    A--;
                }else{
                    sb.append('b');
                    B--;
                }
            }
            index++;
        }
        return sb.toString();
    }

    public String strWithout3a3bV1(int A, int B){
        StringBuilder sb = new StringBuilder("");
        char one = A > B ? 'a' : 'b';
        char two = A > B ? 'b' : 'a';

        while (A > 0 && B > 0 && A > B) {
            sb.append(one);
            sb.append(one);
            sb.append(two);

            A -= 2;
            B--;
        }
        while (A > 0 || B > 0) {
            if (A > 0) {
                sb.append(one);
                A--;
            }
            if (B > 0) {
                sb.append(two);
                B--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringQithoutAAABBB().strWithout3a3b(4,2));
    }


}
