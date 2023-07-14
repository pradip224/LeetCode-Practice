
Rectangle Area
Medium
1.8K
1.6K
Companies
Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.

The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

 

Example 1:

Rectangle Area
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
Example 2:

Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16
 

Constraints:

-104 <= ax1 <= ax2 <= 104
-104 <= ay1 <= ay2 <= 104
-104 <= bx1 <= bx2 <= 104
-104 <= by1 <= by2 <= 104


class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculate the areas of the two rectangles
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        
        // Calculate the coordinates of the overlap rectangle
        int overlapX1 = Math.max(ax1, bx1);
        int overlapY1 = Math.max(ay1, by1);
        int overlapX2 = Math.min(ax2, bx2);
        int overlapY2 = Math.min(ay2, by2);
        
        // Calculate the area of the overlap rectangle
        int overlapArea = 0;
        if (overlapX2 > overlapX1 && overlapY2 > overlapY1) {
            overlapArea = (overlapX2 - overlapX1) * (overlapY2 - overlapY1);
        }
        
        // Calculate the total area covered by the two rectangles
        
        return areaA + areaB - overlapArea;
        
    }
}

