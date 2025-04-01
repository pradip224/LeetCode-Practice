825. Friends Of Appropriate Ages
Solved
Medium
Topics
Companies
There are n persons on a social media website. You are given an integer array ages where ages[i] is the age of the ith person.

A Person x will not send a friend request to a person y (x != y) if any of the following conditions is true:

age[y] <= 0.5 * age[x] + 7
age[y] > age[x]
age[y] > 100 && age[x] < 100
Otherwise, x will send a friend request to y.

Note that if x sends a request to y, y will not necessarily send a request to x. Also, a person will not send a friend request to themself.

Return the total number of friend requests made.

 

Example 1:

Input: ages = [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: ages = [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: ages = [20,30,100,110,120]
Output: 3
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Constraints:

n == ages.length
1 <= n <= 2 * 104
1 <= ages[i] <= 120

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0, i = 0, result = 0, prev = 0;
        for(i = 1; i < ages.length; i++) {
            while(left < i && ages[left] <= 0.5*ages[i]+7) left++;
            while(prev < i && ages[i] != ages[prev]) prev++;
            if(ages[i] == ages[prev] && ages[i] > 0.5*ages[i]+7) result+=i-prev;
            result+=i-left;
        }
        return result;
    }
}
