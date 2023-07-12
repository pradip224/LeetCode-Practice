
Course Schedule
Medium
13.9K
553
Companies
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a graph using adjacency lists
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Create an array to track the visited status of each course
        int[] visited = new int[numCourses];

        // Perform depth-first search (DFS) on each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
        // If the course is being visited in the current DFS traversal, it means there is a cycle
        if (visited[course] == 1) {
            return false;
        }

        // If the course has been visited in a previous DFS traversal, no need to visit again
        if (visited[course] == -1) {
            return true;
        }

        // Mark the course as being visited
        visited[course] = 1;

        // Visit all the prerequisite courses
        for (int prerequisiteCourse : graph.get(course)) {
            if (!dfs(graph, visited, prerequisiteCourse)) {
                return false;
            }
        }

        // Mark the course as visited
        visited[course] = -1;

        return true;
    }
}


