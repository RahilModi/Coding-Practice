package com.programming.leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 *
 * Design a log storage system to implement the following functions:
 *
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.
 *
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 *
 * Example 1:
 *
 * put(1, "2017:01:01:23:59:59");
 * put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
 * Note:
 *
 * There will be at most 300 operations of Put or Retrieve.
 * Year ranges from [2000,2017]. Hour ranges from [00,23].
 * Output for Retrieve has no order required.
 */
public class LogStorageSystem {

    static String TimeStampPattern = "Year:Month:Day:Hour:Minute";
    static Integer[] indices = {4,7,10,13,16};
    final String[] granularities = TimeStampPattern.split(":");

    String getKeyByGranularity(String timeStamp, String granularity){
        for(int i = 0; i < granularities.length; i++) {
            if (granularities[i].equals(granularity)) {
                return timeStamp.substring(0, indices[i]);
            }
        }
        return timeStamp;
    }

    Map<String, Integer> logCollector ;
    public LogStorageSystem() {
        this.logCollector = new HashMap<>();
    }


    void put(int id, String timestamp){
        logCollector.put(timestamp,id);
    }

    List<Integer> retrieve(String start, String end, String granularity){
        List<Integer> res= new ArrayList<>();
        String startKey = getKeyByGranularity(start, granularity);
        String endKey = getKeyByGranularity(end, granularity);
        
        for(String key : logCollector.keySet()){
            String logKey = getKeyByGranularity(key,granularity);
            if(startKey.compareTo(logKey)<=0 && endKey.compareTo(logKey)>0){
                res.add(logCollector.get(key));
            }
        }
        return res;
    }
}
