package com.programming.leetcode.Medium;

public class ZigZagConversion {

    /*n=numRows
    Δ=2n-2    1                           2n-1                         4n-3
    Δ=        2                     2n-2  2n                    4n-4   4n-2
    Δ=        3               2n-3        2n+1              4n-5       .
    Δ=        .           .               .               .            .
    Δ=        .       n+2                 .           3n               .
    Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
    Δ=2n-2    n                           3n-2                         5n-4
    */
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            int crtPos = i;
            int step1 = (numRows -i-1)*2, step2 = i*2;
            int stepSelector = 1;
            int prevPos = -1;
            while(crtPos < s.length()){
                if(prevPos != crtPos)
                    sb.append(s.charAt(crtPos));
                prevPos = crtPos;
                crtPos += stepSelector == 1 ? step1 : step2;
                stepSelector++;
                if(stepSelector % 3 == 0) stepSelector = 1;
            }
        }
        return sb.toString();
    }

    public String convertV1(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i =0;i <numRows;i++){
            sb[i] = new StringBuilder();
        }
        int index = 0, incr = 1;
        for(int i = 0; i < s.length(); i++){
            sb[index].append(s.charAt(i));
            if(index == 0) incr= 1;
            if(index == numRows-1)incr=-1;
            index += incr;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i <numRows;i++){
            res.append(sb[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion obj = new ZigZagConversion();
        System.out.println(obj.convertV1("PAYPALISHIRING",3));

        System.out.println(obj.convert("PAYPALISHIRING",3));
    }
}
