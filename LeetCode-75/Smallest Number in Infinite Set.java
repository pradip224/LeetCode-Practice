
2336. Smallest Number in Infinite Set
Medium
1.4K
145
Companies
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 

Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
 

Constraints:

1 <= num <= 1000
At most 1000 calls will be made in total to popSmallest and addBack.


class SmallestInfiniteSet {
    // Current value to keep track of the next integer to be considered
    int cur;
    
    // Set to store integers that have been added and are smaller than cur
    Set<Integer> s;
    
    // Constructor to initialize the object
    public SmallestInfiniteSet() {
        cur = 1; // Start with the smallest positive integer
        s = new HashSet<>(); // Initialize the set to store additional numbers
    }
    
    // Remove and return the smallest integer from the set
    public int popSmallest() {
        if (!s.isEmpty()) {
            // If the set is not empty, find and remove the smallest element
            int res = Collections.min(s);
            s.remove(res);
            return res;
        } else {
            // If the set is empty, increment cur to consider the next integer
            cur++;
            return cur - 1; // Return the previous value of cur
        }
    }
    
    // Add a positive integer back to the set if it's smaller than cur
    public void addBack(int num) {
        if (cur > num) {
            s.add(num); // Add num to the set if it's smaller than cur
        }
    }
}



/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

 

