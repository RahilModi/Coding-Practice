package com.programming.leetcode.Easy;

import java.io.*;
import java.util.*;

public class TwilioTest {

    public void program1(String filePath1, String filePath2) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath1)));
        Map<String, Integer> hostMap = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            String hostName = line.split("- -")[0].trim();
            hostMap.put(hostName, hostMap.getOrDefault(hostName, 0) + 1);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath2)));
        for (Map.Entry<String, Integer> entry : hostMap.entrySet()) {
            bw.write(entry.getKey() + ' ' + entry.getValue() + '\n');
        }
        bw.flush();
        bw.close();
    }

    //missing words problem
    //not passing all test-cases
    public List<String> program2(String s, String t){

        Map<String,Integer> wordCount = new HashMap<>();
        for(String w : t.split(" ")){
            wordCount.put(w, wordCount.getOrDefault(w,0)+1);
        }
        List<String> res = new ArrayList<>();
        for(String w : s.split(" ") ){
            if(wordCount.containsKey(w)){
                int count = wordCount.get(w);
                if(count == 1) wordCount.remove(w);
                else
                    wordCount.put(w, --count);
            }else{
                res.add(w);
            }
        }
        return res;
    }

    public List<String> program2V2(String s, String t){

        List<String> a = new ArrayList<>();
        a.addAll(Arrays.asList(s.split(" ")));
        List<String> b = new ArrayList<>();
        b.addAll(Arrays.asList(t.split(" ")));
        List<String> res = new ArrayList<>();
        for(int  i = 0; i < a.size(); i++){
            if(i >= b.size()){
                b.add(a.get(i));
                res.add(a.get(i));
            }
            String crt = a.get(i);
            if(!b.get(a.indexOf(crt)).equals(crt)){
                b.add(a.indexOf(crt), crt);
                res.add(crt);
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception  {
        new TwilioTest().program1("/Users/rmodi/TwilioTest-cases/program1-input.txt","/Users/rmodi/TwilioTest-cases/program2-input.txt");
        new TwilioTest().program2V2("I am using Hackerank to improve programming", "to improve").forEach(s-> System.out.print(s+", "));
    }
}
