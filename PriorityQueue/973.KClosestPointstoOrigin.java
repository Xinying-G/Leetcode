// 973. K Closest Points to Origin
// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

// (Here, the distance between two points on a plane is the Euclidean distance.)

// You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

// Example 1:

// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

// 直觉：Priorpity Queue
// 要点，难点：1. Lambda表达comparator的表达式,
// 解决方法： 把数字对比之后存进priorityqueue里面，改变comparator让它变成距离最近
// 归类：Priority Queue
// 难点: Priorityqueue 和comparator
// 复杂度：O(nlongn) 
// 数据结构：PriorityQUeue

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        System.out.println(points.length);
        System.out.println(points[0].length);
        PriorityQueue<int []> pq = new PriorityQueue<int []>((p,q) -> (q[0]*q[0]) - (p[0]*p[0]) + (q[1]*q[1]) - (p[1]*p[1]));
        for(int[] point : points)
        {
            pq.offer(point);
            if(pq.size() > K)
                pq.poll();
        }
        int[][] res = new int[K][2];
        while(K > 0)
        {
            res[--K] = pq.poll();
        }
        return res;
    }
}