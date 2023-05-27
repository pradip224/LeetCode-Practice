
Merge Intervals
Medium
19K
643
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104







import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If mergedIntervals is empty or the current interval does not overlap with the last interval in mergedIntervals
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                mergedIntervals.add(interval);
            } else {
                // Merge the overlapping intervals
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}



