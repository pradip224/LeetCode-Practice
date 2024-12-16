475. Heaters
Solved
Medium
Topics
Companies
Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.

Every house can be warmed, as long as the house is within the heater's warm radius range. 

Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.

Notice that all the heaters follow your radius standard, and the warm radius will the same.

 

Example 1:

Input: houses = [1,2,3], heaters = [2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:

Input: houses = [1,2,3,4], heaters = [1,4]
Output: 1
Explanation: The two heaters were placed at positions 1 and 4. We need to use a radius 1 standard, then all the houses can be warmed.
Example 3:

Input: houses = [1,5], heaters = [2]
Output: 3
 

Constraints:

1 <= houses.length, heaters.length <= 3 * 104
1 <= houses[i], heaters[i] <= 109


class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0){
            return 0;
        }
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int n = houses.length;
        int m = heaters.length; 
        
        int i = 0;
        int j = 0;
        
        int res = 0;
        while(i < n && j < m){
            // for each heaters[j],  compare to heaters[j + 1]
            int dist1 = Math.abs(heaters[j] - houses[i]);
            int dist2 = Integer.MAX_VALUE;
            if(j + 1 < m){
                dist2 = Math.abs(heaters[j + 1] - houses[i]);
            }
            // if j closer to i than j + 1, settle and i ++;
            if(dist1 < dist2){
                res = Math.max(res, dist1);
                i++;
            // else j++;
            }else{
                j++;
            }
        }
        
        return res;
        
    }
}
