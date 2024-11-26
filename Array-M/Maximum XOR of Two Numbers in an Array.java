421. Maximum XOR of Two Numbers in an Array
Solved
Medium
Topics
Companies
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1



class Node {
    Node[] freq = new Node[2];
    boolean flag = false;

    public boolean contains(int idx) {
        return freq[idx] != null;
    }

    public void put(int idx, Node newN) {
        freq[idx] = newN;
    }

    public Node get(int idx) {
        return freq[idx];
    }
}

class Trie {
    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(int num) {
        Node cpy = head;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!cpy.contains(bit)) {
                cpy.put(bit, new Node());
            }

            cpy = cpy.get(bit);
        }
    }

    public int getMax(int num){
        Node cpy = head;
        int maxNum=0;
        for(int i=31; i>=0; i--){
            int bit = (num>>i)&1;
            if(cpy.contains(1-bit)){ // if conatins opposite bit
                maxNum |= (1<<i);
                cpy = cpy.get(1-bit);
            }else{ // don't contains the opposite bit
                cpy = cpy.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie head = new Trie();
        for(int i=0; i<nums.length; i++){
            head.insert(nums[i]);
        }

        int xor=0;
        for(int num:nums){
            xor = Math.max(xor, head.getMax(num));
        }
        return xor;
    }
}