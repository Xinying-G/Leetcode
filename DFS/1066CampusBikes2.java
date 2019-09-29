// 1066. Campus Bikes II
// On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.

// We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.

// The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

// Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.

 

// Example 1:



// Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
// Output: 6
// Explanation: 
// We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.
// Example 2:



// Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
// Output: 4
// Explanation: 
// We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1. Both assignments lead to sum of the Manhattan distances as 4.
 

// Note:

// 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
// All worker and bike locations are distinct.
// 1 <= workers.length <= bikes.length <= 10

// 直觉：不会 O（n）
// 解题方法：检测height of整个tree，如果height of right == h-1,说明缺的node在right tree，否则在left tree，
// 如果在right tree 就加上左边的node的全部，然后再加上计算右边的，否则就计算右边的（2（h-1））个node，然后再计算左边的
// 重点难点：如何利用complete tree特性做到O（nlogn），就是看左边右边是不是complete tree，如果是的话就加上O(2^n)，否则就不
// 数据结构：Tree

class Solution {
    int minDist;
    public int assignBikes(int[][] workers, int[][] bikes) {
        minDist = Integer.MAX_VALUE;
        dfs(new boolean[bikes.length],workers,bikes,0,0);
        return minDist;
    }
    
    public void dfs(boolean[] visited, int[][] workers, int[][] bikes, int ind, int dist){
        if(ind == workers.length){
          minDist = Math.min(minDist,dist);
            return;
        }
        for(int i = 0; i < bikes.length; i++){
            if(!visited[i]){ 
               visited[i] = true;
                dfs(visited,workers,bikes, ind+1, dist + manhattan(bikes[i], workers[ind]));
                visited[i] = false; 
            }
        }   
    }
    public int manhattan(int[] bike, int[] worker){
        return Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
    }
}