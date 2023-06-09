
Best Poker Hand
Easy
302
24
Companies
You are given an integer array ranks and a character array suits. You have 5 cards where the ith card has a rank of ranks[i] and a suit of suits[i].

The following are the types of poker hands you can make from best to worst:

"Flush": Five cards of the same suit.
"Three of a Kind": Three cards of the same rank.
"Pair": Two cards of the same rank.
"High Card": Any single card.
Return a string representing the best type of poker hand you can make with the given cards.

Note that the return values are case-sensitive.

 

Example 1:

Input: ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
Output: "Flush"
Explanation: The hand with all the cards consists of 5 cards with the same suit, so we have a "Flush".
Example 2:

Input: ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
Output: "Three of a Kind"
Explanation: The hand with the first, second, and fourth card consists of 3 cards with the same rank, so we have a "Three of a Kind".
Note that we could also make a "Pair" hand but "Three of a Kind" is a better hand.
Also note that other cards could be used to make the "Three of a Kind" hand.
Example 3:

Input: ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
Output: "Pair"
Explanation: The hand with the first and second card consists of 2 cards with the same rank, so we have a "Pair".
Note that we cannot make a "Flush" or a "Three of a Kind".
 

Constraints:

ranks.length == suits.length == 5
1 <= ranks[i] <= 13
'a' <= suits[i] <= 'd'
No two cards have the same rank and suit.






class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        // Check for "Flush"
        boolean isFlush = true;
        char firstSuit = suits[0];
        for (char suit : suits) {
            if (suit != firstSuit) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) {
            return "Flush";
        }
        
        // Check for "Three of a Kind"
        int[] rankCounts = new int[14]; // There are ranks from 1 to 13, so we use an array of size 14
        for (int rank : ranks) {
            rankCounts[rank]++;
            if (rankCounts[rank] == 3) {
                return "Three of a Kind";
            }
            
        }
        
        // Check for "Pair"
        for (int rankCount : rankCounts) {
            if (rankCount == 2) {
                return "Pair";
            }
        }
        
        // If no other category is met, return "High Card"
        return "High Card";
    }
}




