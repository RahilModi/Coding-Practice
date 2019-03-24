package com.programming.leetcode.Medium;

public class AdditiveNumber {

    //1 1 2 3 5 8
    //l m r

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length(),l,m,r;
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0') break;
            for (int j = i+1; j < n; j++) {
                l = 0; m = i; r = j;
                if (num.charAt(m) == '0' && r > m+1) break;
                while (r < n) {
                    Long result = (Long.parseLong(num.substring(l, m)) +
                            Long.parseLong(num.substring(m, r)));
                    String res = result.toString();
                    if (num.substring(r).startsWith(res)) {
                        l = m; m = r; r += res.length();
                    }
                    else {
                        break;
                    }
                }
                if (r == n) return true;
            }
        }
        return false;
    }

    public boolean isAdditiveNumberV1(String s) {
        return isAdditiveNumber(s, 0, 0L, 0L, 0);
    }
    public boolean isAdditiveNumber(String s, int index, long n1, long n2, int c) {
        if(c > 2 && index == s.length()) return true;
        long num = 0;
        while(index < s.length()){
            char ch = s.charAt(index++);
            num = num * 10 + ch - '0';
            while(num != 0 && ch - '0' == 0 && index < s.length() && s.charAt(index) == '0'){
                num = num * 10 + s.charAt(index++) - '0';
            }
            if(n1 + n2  < num && c >= 2) break;
            if((n1 + n2 == num || c < 2) && isAdditiveNumber(s, index, n2, num, c+1))
                return true;
            if(num == 0) break;
        }
        return false;
    }

    public static void main(String[] args) {
        AdditiveNumber obj = new AdditiveNumber();
        System.out.println(obj.isAdditiveNumberV1("101123581321345589144"));
        System.out.println(obj.isAdditiveNumber("199100199"));
        System.out.println(obj.isAdditiveNumber("112358"));
    }

}
