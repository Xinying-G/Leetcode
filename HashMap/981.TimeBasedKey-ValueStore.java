// 981. Time Based Key-Value Store
// Medium

// 297

// 46

// Favorite

// Share
// Create a timebased key-value store class TimeMap, that supports two operations.

// 1. set(string key, string value, int timestamp)

// Stores the key and value, along with the given timestamp.
// 2. get(string key, int timestamp)

// Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
// If there are multiple such values, it returns the one with the largest timestamp_prev.
// If there are no values, it returns the empty string ("").
 

// Example 1:

// Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
// Output: [null,null,"bar","bar",null,"bar2","bar2"]
// Explanation:   
// TimeMap kv;   
// kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
// kv.get("foo", 1);  // output "bar"   
// kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
// kv.set("foo", "bar2", 4);   
// kv.get("foo", 4); // output "bar2"   
// kv.get("foo", 5); //output "bar2"   

// Example 2:

// Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
// Output: [null,null,null,"","high","high","low","low"]
 

// Note:

// All key/value strings are lowercase.
// All key/value strings have length in the range [1, 100]
// The timestamps for all TimeMap.set operations are strictly increasing.
// 1 <= timestamp <= 10^7
// TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
// Accepted

// HashMap store key, Pair<TimeStampm,Value>, 用binarySearch来Search Value，刚好大于timesatmp的，然后在选取前一个

import javafx.util.Pair; 
class TimeMap {
    Map<String,List<Pair<Integer,String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer,String>> list = map.getOrDefault(key,new ArrayList<>());
        list.add(new Pair<Integer,String>(timestamp,value));
        map.put(key,list);        
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> list = map.get(key);
        if(list == null) return "";
        // int i = 0;
        // while(i < list.size() && list.get(i).getKey() <= timestamp){
        //     i++;
        // }
        
        //10,20,
        int left = 0, right = list.size()-1;
        while(left < right){
            int mid = (left + right)/2;
            if(list.get(mid).getKey() <= timestamp) left = mid+1;
            else right = mid;
        }
        
        if(timestamp >= list.get(right).getKey()) return list.get(right).getValue();
        if(left -1 < 0) return "";
        return list.get(left-1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */