package com.programming.leetcode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMapping = new HashMap<>();

        for(String domain : cpdomains){

            String[] splitedDomain = domain.split(" ",2);

            int count = Integer.parseInt(splitedDomain[0]);

            String domainName = splitedDomain[1];

            domainCountMapping.put(splitedDomain[1], domainCountMapping.getOrDefault(splitedDomain[1],0)+count);

            for(int i = 0; i < splitedDomain[1].length() ; i++){
                if(splitedDomain[1].charAt(i) == '.'){
                    String subdomainName = splitedDomain[1].substring(i+1);
                    domainCountMapping.put(subdomainName,domainCountMapping.getOrDefault(subdomainName,0)+count);
                }
            }

        }

        List<String> result = new ArrayList<>();
        for(String key : domainCountMapping.keySet()){
            result.add(domainCountMapping.get(key)+" "+key);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> res = SubdomainVisitCount.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});

        for(String str : res){
            System.out.println(str);
        }
    }
}
