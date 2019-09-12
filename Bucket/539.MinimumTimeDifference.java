// 539. Minimum Time Difference
// Medium

// 236

// 84

// Favorite

// Share
// Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
// Example 1:
// Input: ["23:59","00:00"]
// Output: 1
// Note:
// The number of time points in the given list is at least 2 and won't exceed 20000.
// The input time is legal and ranges from 00:00 to 23:59.

// 直觉：把它都变成分钟，然后sort一下，然后两两相比
// 要点，难点：如何比两个时间，第一个时间往后走，跨越一天，到达第二个时间
// 第一个时间，不往后走也能到达第二个时间
// 第二个时间往后走，跨越一天到达第一个时间
// 第二个时间往后走，步跨越一天也能到达第一个时间
// 解决方法：把它都变成分钟，然后sort一下，然后两两相比，最后要比较一下头尾
// 归类：Array
// 难点: 换算成时间两两相比
// 复杂度：O(nlogn) 
// 数据结构：Array

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for(String timePoint: timePoints)
        {
            String[] strs = timePoint.split(":");
            int minute = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]);
            minutes[i] = minute;
            i++;
        }
        
        Arrays.sort(minutes);
        int min_min = 60*24;
        // int min_ind = -1;
        for(int j = 0; j < minutes.length -1; j++)
        {
            int value = Math.min(
                Math.min(Math.abs(1440 + minutes[j] - minutes[j+1]), 
                         Math.abs(minutes[j] - minutes[j+1])),
                        Math.abs(1440 - minutes[j] + minutes[j+1]));
            System.out.println(minutes[j] + " " + minutes[j+1]);
            
            if(value < min_min)
                min_min = value;
        }
        
        int head = 0, end = minutes.length-1;
        int value = Math.min(
            Math.min(Math.abs(1440 + minutes[head] - minutes[end]), 
                     Math.abs(minutes[head] - minutes[end])),
                    Math.abs(1440 - minutes[head] + minutes[end]));
        if(value < min_min)
            min_min = value;
        
        return min_min;
    }
}

// 直觉：如上
// 要点，难点：
// 解决方法：Bucket的算法，因为只有1440个可能性，所以把每一个时间放进这个bucket里面，如果一个时间
// 出现了两次，return 0，不然的话就前一个时间和后一个差的比，一直比到最后，不要忘了firts和last也比一下
// 归类：Bucket
// 难点: 没有想到用bucket
// 复杂度： O(1)
// 数据结构：bucket
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
}