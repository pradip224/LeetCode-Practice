1812. Determine Color of a Chessboard Square
Easy
730
15
Companies
You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.



Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.

 

Example 1:

Input: coordinates = "a1"
Output: false
Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
Example 2:

Input: coordinates = "h3"
Output: true
Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
Example 3:

Input: coordinates = "c7"
Output: false
 

Constraints:

coordinates.length == 2
'a' <= coordinates[0] <= 'h'
'1' <= coordinates[1] <= '8'


class Solution {
    public boolean squareIsWhite(String coordinates) {
        char file = coordinates.charAt(0); // Get the letter (file)
        int rank = coordinates.charAt(1) - '0'; // Get the number (rank)
        
        // Check if the sum of the ASCII values of file and rank is even
        // If it's even, the square is white; otherwise, it's black
        //ex. 'a'+1 = 98
        return (file + rank) % 2 != 0;
    }
}
