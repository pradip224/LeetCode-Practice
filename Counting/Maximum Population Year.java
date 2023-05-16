
Maximum Population Year
Easy
984
168
Companies
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

 

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.
 

Constraints:

1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050





class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101]; // Timeline of 101 years (1950-2050)
        
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            
            for (int i = birth; i < death; i++) {
                years[i - 1950]++; // Increment population count for each year
            }
        }
        
        int maxPopulation = years[0];
        int maxYear = 1950;
        
        for (int i = 1; i < years.length; i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                maxYear = i + 1950; // Calculate the actual year from the index
            }
        }
        
        return maxYear;
    }
}

