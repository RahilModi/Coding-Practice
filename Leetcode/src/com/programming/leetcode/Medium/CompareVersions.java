package com.programming.leetcode.Medium;

public class CompareVersions {

    public int compareVersion(String version1, String version2) {
        String[]v1 = version1.split("\\.");
        String[]v2 = version2.split("\\.");
        int l=0, j =0;
        while (l<v1.length && j<v2.length){
            int comp = Integer.valueOf(v1[l]).compareTo(Integer.valueOf(v2[l]));
            if(comp < 0) return -1;
            else if(comp > 0) return 1;
            else {
                l++; j++;
            }
        }
        while (l < v1.length){
            if(Integer.parseInt(v1[l++]) > 0) return 1;
        }
        while (j < v2.length){
            if(Integer.parseInt(v2[j++]) > 0) return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersions obj = new CompareVersions();
        System.out.println(obj.compareVersion("0.1","1.1"));
        System.out.println(obj.compareVersion("1.0.1","1"));
        System.out.println(obj.compareVersion("7.5.2.4","7.5.3"));
        System.out.println(obj.compareVersion("1.01","1.001"));
        System.out.println(obj.compareVersion("1.0","1.0.0"));
    }

}
