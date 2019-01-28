package com.programming.leetcode.Easy;

public class SimilarRGBColor {

    private static final String colorCodes = "0123456789ABCDEF";

    public int atoi(String colorCode){
        char[] chars = colorCode.toUpperCase().toCharArray();
        int val_of_color = 0;
        for(int i = 0; i < chars.length; i++){
            if(Character.isDigit(chars[i])){
                val_of_color +=  ((int)(chars[i]-'0')) * (i == 0 ? 16 : 1);
            }else{
                int crt_letter_val = 10 + (chars[i]-'A');
                val_of_color += (crt_letter_val)  * (i == 0 ? 16 : 1);
            }
        }
        return val_of_color;
    }

    //Similar letter like 11,22,33,are differ 11 hexadecimal digits which is equivalent to 17 decimal number
    //And to reach upper or lower number we can decide by reminder value if it is more than 8 we will increase the value by 1
    //e1 => dd,ee,ff
    public String similarRGB(String color) {
        StringBuilder bld = new StringBuilder("#");
        for (int i = 1; i < color.length(); i += 2) {
            String RorGorB = color.substring(i, i + 2);
            int code = atoi(RorGorB);
            int idx = code / 17 + (code % 17 > 8 ? 1 : 0);
            bld.append(colorCodes.charAt(idx));
            bld.append(colorCodes.charAt(idx));
        }
        return bld.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimilarRGBColor().similarRGB("#09f166"));
    }
}