// /**
//  56. Merge Intervals
// Example 1:

// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// 直觉：sort，然后找交叉，如果不能交叉，那下一个肯定也不能交叉，
// 要点，难点：1.sort Collection需要写 comparator，如何写comparator，
//  2. 比的时候用了start和end，如果交叉就把他俩放大，如果下一次不交叉就插入res，并且把start和end initialize到合适的
// 位置
// 归类：Array,DP
// 难点: comparator，比较交叉
// 复杂度： O(n)
// 数据结构：下一次loop交付上一次的东西

 // * Definition for an interval.
 // * public class Interval {
 // *     int start;
 // *     int end;
 // *     Interval() { start = 0; end = 0; }
 // *     Interval(int s, int e) { start = s; end = e; }
 // * }
 // */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0)
            return intervals;
        
        Collections.sort(intervals,new IntervalComparator());
        List<Interval> res = new ArrayList<Interval>();
        
        int start  = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++)
        {
            if(end >= intervals.get(i).start)
            {
                end = Math.max(intervals.get(i).end,end);
            }
            else {
              res.add(new Interval(start,end));
              start = intervals.get(i).start;
              end = intervals.get(i).end;
            }
        }
        
        res.add(new Interval(start,end));
        return res;
    }
    
    private class IntervalComparator implements Comparator<Interval>
    {
        public int compare(Interval a, Interval b)
        {
            return a.start - b.start;
        }
    }
}