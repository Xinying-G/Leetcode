// 253. Meeting Rooms II
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// Example 1:

// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
// Example 2:

// Input: [[7,10],[2,4]]
// Output: 1
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i = 0; i < n; i++)
        {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int room = 0;
        int endInd = 0;
        for(int i = 0; i < n; i++)
        {
            if(starts[i] < ends[endInd])
                room++;
            else endInd++;
        }
        return room;
    }
}