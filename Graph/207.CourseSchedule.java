// 207. Course Schedule

// There are a total of n courses you have to take, labeled from 0 to n-1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// Example 1:

// Input: 2, [[1,0]] 
// Output: true
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0. So it is possible.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++)
        {
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            if(matrix[pre][ready] == 0)
            {
                indegree[ready]++;
                matrix[pre][ready]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int counter = 0;
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
                counter++;
            }
        }
        
        while(!queue.isEmpty())
        {
            int pre = queue.poll();
            for(int i = 0; i < numCourses; i++)
            {
                if(matrix[pre][i] == 1)
                {
                    indegree[i]--;
                    if(indegree[i] == 0)
                    {
                        queue.add(i);
                        counter++;
                    }
                }
            }
        }
        
        return counter == numCourses;
            