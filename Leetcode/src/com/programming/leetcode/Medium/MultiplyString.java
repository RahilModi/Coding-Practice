package com.programming.leetcode.Medium;

public class MultiplyString {

    public String multiply(String num1, String num2) {
        if(num2.length() > num1.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int[] res = new int[num1.length()+num2.length()];
        int carry= 0, prev = 0;
        for(int i = num2.length()-1; i >= 0; i--){
            int idx = prev++;
            for(int j = num1.length()-1; j>=0; j--){
                int ans = (int) (num2.charAt(i)-'0') * (int)(num1.charAt(j) -'0');
                ans += carry;
                carry = ans/ 10;
                int c = 0, pos = res.length - 1 - idx;
                int valAtPos = (ans % 10);
                do {
                    valAtPos += res[pos];
                    valAtPos += c;
                    c = valAtPos/10;
                    res[pos--] = (valAtPos % 10);
                    valAtPos=0;
                }while (c != 0);
                idx++;
            }
            while(carry != 0){
                int temp = res.length - 1 - idx;
                int valAttemp = res[temp];
                valAttemp += carry;
                carry = valAttemp /10;
                res[temp] = (valAttemp%10);
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean found=false;
        for(int r : res) {
            if (r == 0 && !found) {
                if (sb.length()==0)
                    sb.append(0);
                continue;
            } else {
                if(!found) {
                    sb.setLength(0);
                    found = true;
                }
                sb.append(r);
            }
        }
        return sb.toString();
    }

    //Well written..
    public String multiplyV1(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] product = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int p = i + j;
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + product[p + 1];
                product[p] += prod / 10;
                product[p + 1] = prod % 10;
            }
        }

        int start = 0;
        while (start < product.length && product[start] == 0) start++;
        StringBuilder ans = new StringBuilder();
        for (int i = start; i < product.length; i++) {
            ans.append(product[i]);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        MultiplyString obj = new MultiplyString();
        System.out.println(obj.multiply("123","456"));
        System.out.println(obj.multiply("2","3"));
        System.out.println(obj.multiply("0","0"));
    }

}
