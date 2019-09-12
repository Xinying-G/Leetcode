// 399. Evaluate Division
// Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

// Example:
// Given a / b = 2.0, b / c = 3.0.
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
// return [6.0, 0.5, -1.0, 1.0, -1.0 ].

// The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

// According to the example above:

// equations = [ ["a", "b"], ["b", "c"] ],
// values = [2.0, 3.0],
// queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

// The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

// 直觉：不知道，看了hint是图的题
// 要点，难点：自己创建一个图，adjacency matrix，双边的，边有weight，用了hashmap，
// 对每一个query，用dfs找是否有到end的点的路径并且把路径乘起来，对于每一个图上的点，只可以路过一次，因此有一个used的数组记录
// 归类：Graph
// 难点: 
// 复杂度： Build Tree： O（n），query： O（n）each
// 数据结构：HashMap，adj matrix
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] res = new double[n];
        HashMap<String,Integer> index = new HashMap<>();
        double[][] graph = buildGraph(equations, values, index);
        res = query(graph,index,queries);
        return res;
    }
    
    public double[][] buildGraph(List<List<String>> equations, double[] values, HashMap<String,Integer> index){
        int ind = 0;
        for(List<String> equation: equations)
        {
            if(!index.containsKey(equation.get(0))){
                index.put(equation.get(0),ind); 
                ind++;
            }
            if(!index.containsKey(equation.get(1))){
               index.put(equation.get(1),ind);
                ind++;
            }
        }
        double[][] graph = new double[ind][ind];
        
        for(int i = 0; i < equations.size(); i++)
        {   
            graph[index.get(equations.get(i).get(0))][index.get(equations.get(i).get(1))] = 
                values[i];
            graph[index.get(equations.get(i).get(1))][index.get(equations.get(i).get(0))] = 
                1/values[i];
        }
        
        return graph;
    }
    
    public double[] query(double[][] graph, HashMap<String,Integer> index, List<List<String>> queries)
    {
        double[] result = new double[queries.size()];
        for(int i = 0; i < result.length; i++)
        {
            int start,end;
            if(index.containsKey(queries.get(i).get(0)))
                start = index.get(queries.get(i).get(0));
            else {result[i] =  -1; continue;}
            
            if(index.containsKey(queries.get(i).get(1)))
                end = index.get(queries.get(i).get(1));
            else {result[i] = -1; continue;}
            //             DfS
            boolean[] used = new boolean[graph.length];
            result[i] = dfs(graph,index,start,end,used);
            if(result[i] == 0) result[i] = -1;
            
        }
        return result;
    }
    
    public double dfs(double[][] graph, HashMap<String,Integer> index,int start, int end, boolean[] used){
        double res = 0;
        used[start] = true;
        if(start == end) return 1;
        for(int i = 0; i < graph.length; i++)
        {
            if(graph[start][i] != 0 && used[i] == false){
                double tmp = graph[start][i]*dfs(graph,index,i,end,used);
                if(tmp != 0) res = tmp;
            }
        }
        return res;
    }
}