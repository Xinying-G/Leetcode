// 347. Top K Frequent Elements
// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
// Note:

// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> maxQueue = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            maxQueue.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(k > 0)
        {
            res.add(maxQueue.poll().getKey());
            k--;
        }
        return res;
    }
}