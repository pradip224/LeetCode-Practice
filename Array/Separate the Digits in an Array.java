2553. Separate the Digits in an Array
Solved
Easy
Topics
Companies
Hint
Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

To separate the digits of an integer is to get all the digits it has in the same order.

For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
 

Example 1:

Input: nums = [13,25,83,77]
Output: [1,3,2,5,8,3,7,7]
Explanation: 
- The separation of 13 is [1,3].
- The separation of 25 is [2,5].
- The separation of 83 is [8,3].
- The separation of 77 is [7,7].
answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
Example 2:

Input: nums = [7,1,3,9]
Output: [7,1,3,9]
Explanation: The separation of each integer in nums is itself.
answer = [7,1,3,9].
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 105


///// Method -- 1 Using By ArrayList

class Solution {
    public int[] separateDigits(int[] nums) {
            // create a array list type of Integer
            ArrayList<Integer> al = new ArrayList<>();
            // traversal on the array
            for(int i = 0; i< nums.length; i ++) {
                    // initialize an string and add with array element
                    String s = nums[i]+ "";
                    // now traversal on the string 
                    // after that add in array list and parseint
                    for(int j = 0; j< s.length(); j ++) al.add(Integer.parseInt(s.charAt(j)+""));
            }
            // initialize the new answer array size of arraylist
            int ans[] = new int[al.size()];
            // now traversal on the arraylist and put all element in the answer array
            for(int i = 0; i< al.size(); i++) ans[i] = al.get(i);
            
            return ans;
    }
}



// Method -- 2 By Stack 

// class Solution {
//     public int[] separateDigits(int[] nums) {
//         int[] ans = new int[6000];
//         int c = 0;
//         for(int x:nums){
//             Stack<Integer> s = new Stack<>();
//             for(int y = x; y > 0; y /= 10)s.push(y%10);
//             while(!s.isEmpty())ans[c++] = s.pop();
//         }
//         return Arrays.copyOf(ans, c);
//     }
// }