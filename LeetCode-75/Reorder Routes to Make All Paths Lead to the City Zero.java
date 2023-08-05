1466. Reorder Routes to Make All Paths Lead to the City Zero
Medium
3.6K
80
Companies
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

 

Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 

Constraints:

2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi


class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[] {to, 1});   // Normal edge from 'from' to 'to'
            graph.get(to).add(new int[] {from, 0});   // Reversed edge from 'to' to 'from'
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    private int dfs(int city, List<List<int[]>> graph, boolean[] visited) {
        visited[city] = true;
        int reversedEdges = 0;
        
        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int edgeType = neighbor[1];
            
            if (!visited[nextCity]) {
                reversedEdges += edgeType; // If the edge is reversed (edgeType = 1), increase the count
                reversedEdges += dfs(nextCity, graph, visited);
            }
        }
        
        return reversedEdges;
    }
}

