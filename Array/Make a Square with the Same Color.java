3127. Make a Square with the Same Color
Solved
Easy
Topics
Companies
Hint
You are given a 2D matrix grid of size 3 x 3 consisting only of characters 'B' and 'W'. Character 'W' represents the white color, and character 'B' represents the black color.

Your task is to change the color of at most one cell so that the matrix has a 2 x 2 square where all cells are of the same color.

Return true if it is possible to create a 2 x 2 square of the same color, otherwise, return false.

 

Example 1:

 
 
 
 
 
 
 
 
 
Input: grid = [["B","W","B"],["B","W","W"],["B","W","B"]]

Output: true

Explanation:

It can be done by changing the color of the grid[0][2].

Example 2:

 
 
 
 
 
 
 
 
 
Input: grid = [["B","W","B"],["W","B","W"],["B","W","B"]]

Output: false

Explanation:

It cannot be done by changing at most one cell.

Example 3:

 
 
 
 
 
 
 
 
 
Input: grid = [["B","W","B"],["B","W","W"],["B","W","W"]]

Output: true

Explanation:

The grid already contains a 2 x 2 square of the same color.

 

Constraints:

grid.length == 3
grid[i].length == 3
grid[i][j] is either 'W' or 'B'.


class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<=1;i++)
        {
            for(int j=0;j<=1;j++)
            {
                if(check(grid,i,j))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char grid[][], int i, int j)
    {
        int count=0,count1=0;
        for(int i1=i;i1<i+2;i1++)
        {
            for(int j1=j;j1<j+2;j1++)
            {
                if(grid[i1][j1] == 'B')
                {
                    count++;
                }
                else
                {
                    count1++;
                }
            }
        }
        return count<=1 || count1<=1;
    }
}