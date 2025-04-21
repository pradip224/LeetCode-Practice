851. Loud and Rich
Solved
Medium
Topics
Companies
There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.

You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).

Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.

 

Example 1:

Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
Output: [5,5,2,5,4,5,6,7]
Explanation: 
answer[0] = 5.
Person 5 has more money than 3, which has more money than 1, which has more money than 0.
The only person who is quieter (has lower quiet[x]) is person 7, but it is not clear if they have more money than person 0.
answer[7] = 7.
Among all people that definitely have equal to or more money than person 7 (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x]) is person 7.
The other answers can be filled out with similar reasoning.
Example 2:

Input: richer = [], quiet = [0]
Output: [0]
 

Constraints:

n == quiet.length
1 <= n <= 500
0 <= quiet[i] < n
All the values of quiet are unique.
0 <= richer.length <= n * (n - 1) / 2
0 <= ai, bi < n
ai != bi
All the pairs of richer are unique.
The observations in richer are all logically consistent.

import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        // 🔹 Step 1: Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 🔹 Step 2: Build the graph (y → x means y is poorer than x)
        for (int[] rich : richer) {
            graph[rich[1]].add(rich[0]);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // -1 means unprocessed
        
        // 🔹 Step 3: DFS to find the quietest person for each node
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                dfs(graph, i, quiet, ans);
            }
        }
        
        return ans;
    }
    
    private int dfs(ArrayList<Integer>[] graph, int node, int[] quiet, int[] ans) {
        if (ans[node] != -1) {
            return ans[node]; // Return memoized result
        }
        
        int min = node; // Start with current person
        
        for (int next : graph[node]) {
            int cur = dfs(graph, next, quiet, ans); // Recursive DFS
            
            // 🔍 If a quieter person is found, update `min`
            if (quiet[cur] < quiet[min]) {
                min = cur;
            }
        }
        
        ans[node] = min; // Store the result for memoization
        return min;
    }
}
