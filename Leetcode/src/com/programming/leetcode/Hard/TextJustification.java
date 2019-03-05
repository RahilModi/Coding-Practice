package com.programming.leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    //This is an optimum way of spacing...but question asked greedy way..
    public List<String> fullJustify(String[] words, int maxWidth) {

        int n= words.length;
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++){
            int totalLen = 0;
            for(int j = i; i < n; j++){
                totalLen += words[j].length();
                if(totalLen <= maxWidth){
                    int numEmptySpace =  maxWidth - totalLen;
                    cost[i][j] = numEmptySpace * numEmptySpace;
                    totalLen++;
                }else{
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int minCost[] = new int[n];
        int result[] = new int[n];
        for(int i = n-1; i >= 0 ; i--){
            minCost[i] = cost[i][n-1];
            result[i] = words.length;
            for(int j=n-1; j > i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + cost[i][j-1]){
                    minCost[i] = minCost[j] + cost[i][j-1];
                    result[i] = j;
                }
            }
        }
        List<String> res = new ArrayList<>();
        int i = 0,j;
        StringBuilder sb = new StringBuilder();
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                sb.append(words[k] + (j < k-1 ? " ":""));
            }
            i=j;
            res.add(sb.toString());
            sb.setLength(0);
        }while(j < words.length);

        return res;
    }


    public List<String> fullJustifyV1(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        int index = 0;
        while(index < words.length){
            int crtWLen = words[index].length();
            int next = index+1;
            while(next < words.length){
                if(crtWLen + words[next].length()+1 > maxWidth) break;
                crtWLen += words[next].length()+1;
                next++;
            }
            int diff = next - index - 1;
            if(next == words.length || diff == 0){
                for(int i = index; i < next; i++){
                    sb.append(words[i] + (i != next-1 ? " " : ""));
                }
                for(int i =sb.length(); i < maxWidth; i++){
                    sb.append(" ");
                }
            }else{
                int space =( maxWidth - crtWLen )/ diff;
                int r = (maxWidth -crtWLen)%diff;
                for(int i = index; i < next; i++){
                    sb.append(words[i]);
                    if(i < next - 1){
                        for(int j = 0; j <=space+((i-index) < r ? 1 : 0) ; j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            sb.setLength(0);
            index = next;
        }
        return res;

    }

    public static void main(String[] args) {
        TextJustification obj  = new TextJustification();
        System.out.println(obj.fullJustifyV1(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
    }

}
