3242. Design Neighbor Sum Service
Attempted
Easy
Topics
Companies
Hint
You are given a n x n 2D array grid containing distinct elements in the range [0, n2 - 1].

Implement the NeighborSum class:

NeighborSum(int [][]grid) initializes the object.
int adjacentSum(int value) returns the sum of elements which are adjacent neighbors of value, that is either to the top, left, right, or bottom of value in grid.
int diagonalSum(int value) returns the sum of elements which are diagonal neighbors of value, that is either to the top-left, top-right, bottom-left, or bottom-right of value in grid.


 

Example 1:

Input:

["NeighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]

[[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]

Output: [null, 6, 16, 16, 4]

Explanation:



The adjacent neighbors of 1 are 0, 2, and 4.
The adjacent neighbors of 4 are 1, 3, 5, and 7.
The diagonal neighbors of 4 are 0, 2, 6, and 8.
The diagonal neighbor of 8 is 4.
Example 2:

Input:

["NeighborSum", "adjacentSum", "diagonalSum"]

[[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]

Output: [null, 23, 45]

Explanation:



The adjacent neighbors of 15 are 0, 10, 7, and 6.
The diagonal neighbors of 9 are 4, 12, 14, and 15.
 

Constraints:

3 <= n == grid.length == grid[0].length <= 10
0 <= grid[i][j] <= n2 - 1
All grid[i][j] are distinct.
value in adjacentSum and diagonalSum will be in the range [0, n2 - 1].
At most 2 * n2 calls will be made to adjacentSum and diagonalSum.


class neighborSum {
    int[][] grid;
    Map<Integer,Pair<Integer,Integer>> map;
    int row;
    int col;
    public neighborSum(int[][] grid) {
        this.grid=grid;
        map=new HashMap<Integer,Pair<Integer,Integer>>();
        row=grid.length;
        col=grid[0].length;
        for(int i=0;i<row*col;i++){
            map.put(grid[i/col][i%col],new Pair(i/col,i%col));
        }
    }
    
    public int adjacentSum(int value) {
        Pair<Integer,Integer> p=map.get(value);
        int currentRow=p.getKey();
        int currentCol=p.getValue();
        int sum=0;
        if(currentRow-1>=0)
            sum=sum+grid[currentRow-1][currentCol];
        if(currentCol-1>=0)
            sum=sum+grid[currentRow][currentCol-1];
        if(currentCol+1<col)
            sum=sum+grid[currentRow][currentCol+1];
        if(currentRow+1<row)
            sum=sum+grid[currentRow+1][currentCol];
        return sum;
    }
    
    public int diagonalSum(int value) {
        Pair<Integer,Integer> p=map.get(value);
        int currentRow=p.getKey();
        int currentCol=p.getValue();
        int sum=0;
        if(currentRow-1>=0){
            if(currentCol-1>=0)
                sum=sum+grid[currentRow-1][currentCol-1];
            if(currentCol+1<col)
                sum=sum+grid[currentRow-1][currentCol+1];
        }
        if(currentRow+1<row){
            if(currentCol-1>=0)
                sum=sum+grid[currentRow+1][currentCol-1];
            if(currentCol+1<col)
                sum=sum+grid[currentRow+1][currentCol+1];
        }
        return sum;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */