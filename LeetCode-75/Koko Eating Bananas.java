
875. Koko Eating Bananas
Medium
8.6K
422
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating speed
        int right = getMaxPiles(piles); // Maximum possible eating speed
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Helper function to check if Koko can finish eating all piles within h hours at given eating speed
    private boolean canFinish(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += pile / speed; // Ceil division
            if(pile%speed > 0){
                hoursNeeded++;
            }
        }
        return hoursNeeded <= h;
    }
    
    // Helper function to get the maximum pile size
    private int getMaxPiles(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }
}


