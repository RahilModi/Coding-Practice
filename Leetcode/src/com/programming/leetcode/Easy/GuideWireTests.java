package com.programming.leetcode.Easy;

public class GuideWireTests {

    public String solution(int[] T) {
        // write your code in Java SE 8
        if(T == null || T.length == 0 || T.length % 4 != 0) return null;
        String[] seasons = {"WINTER","SPRING","SUMMER","AUTUMN"};
        int numDaysOfSeason = T.length / 4;
        String season = "";
        int maxAmplitude = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++){
            int crtMin = Integer.MAX_VALUE, crtMax = Integer.MIN_VALUE, crtAmplitude = Integer.MIN_VALUE;
            for(int j = numDaysOfSeason * i ; j < ((i+1) * numDaysOfSeason); j++){
                crtMin = Math.min(crtMin, T[j]);
                crtMax = Math.max(crtMax, T[j]);
            }

            crtAmplitude = Math.abs(crtMin-crtMax);
            if(crtAmplitude > maxAmplitude){
                maxAmplitude = crtAmplitude;
                //season = SeasonType(i).toString();
                season = seasons[i];
            }
        }
        return season;
    }

    public static void main(String[] args) {
        GuideWireTests obj = new GuideWireTests();
        System.out.println(obj.solution(new int[]{-3,-14,-5,7,8,42,8,3}));
    }
}
