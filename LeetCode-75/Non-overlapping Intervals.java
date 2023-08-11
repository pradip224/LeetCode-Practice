

435. Non-overlapping Intervals
Medium
7.3K
189
Companies
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104


import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0; // No overlaps to remove
        }
        
        // Sort intervals based on their end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int count = 0; // Number of intervals to remove
        int prevEnd = intervals[0][1]; // End time of the first interval
        
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one
            if (intervals[i][0] < prevEnd) {
                count++; // Remove the current interval
            } else {
                prevEnd = intervals[i][1]; // Update previous end time
            }
        }
        
        return count;
    }
}

