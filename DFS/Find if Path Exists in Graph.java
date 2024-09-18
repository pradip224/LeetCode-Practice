1971. Find if Path Exists in Graph
Solved
Easy
Topics
Companies
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.


class Solution {
    static int par[];
    static int size[];
    static int rank[];   // to find the number of linkage to that parent
    // here the T.C of find will be O(logn)
    // same goes for the union

    // here we can do one more optimization which is called path compresion
    // in which we set the child to its parent while returning from the base case of find operation

    // now using this optimization we have reduce the T.C from O(logn) to O(log*n)
    // here log*n means that minimum how many operation is needed to convert n to less than 1 w.r.t base 2;
    // for example log*2^32 is approx 5;

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)  return; // Both a and b are in the same set
        if(rank[a]>= rank[b]){
            par[b] = a;
            rank[a]++;

        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    public boolean validPath(int n, int[][] edges, int s, int d) {
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            par[i] = i;
        }
        for(var a : edges){
            int x = find(a[0]);
            int y = find(a[1]);
            if(x!=y){
                union(x,y);
            }
        }

        if(find(s)==find(d)) return true;
        else return false;
    }
}1971. Find if Path Exists in Graph
Solved
Easy
Topics
Companies
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.


class Solution {
    static int par[];
    static int size[];
    static int rank[];   // to find the number of linkage to that parent
    // here the T.C of find will be O(logn)
    // same goes for the union

    // here we can do one more optimization which is called path compresion
    // in which we set the child to its parent while returning from the base case of find operation

    // now using this optimization we have reduce the T.C from O(logn) to O(log*n)
    // here log*n means that minimum how many operation is needed to convert n to less than 1 w.r.t base 2;
    // for example log*2^32 is approx 5;

    static int find(int a){
        if(par[a]==a) return a;
        else return par[a] = find(par[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)  return; // Both a and b are in the same set
        if(rank[a]>= rank[b]){
            par[b] = a;
            rank[a]++;

        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    public boolean validPath(int n, int[][] edges, int s, int d) {
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            par[i] = i;
        }
        for(var a : edges){
            int x = find(a[0]);
            int y = find(a[1]);
            if(x!=y){
                union(x,y);
            }
        }

        if(find(s)==find(d)) return true;
        else return false;
    }
}