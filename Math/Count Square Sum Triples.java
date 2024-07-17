1925. Count Square Sum Triples
Solved
Easy
Topics
Companies
Hint
A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

 

Example 1:

Input: n = 5
Output: 2
Explanation: The square triples are (3,4,5) and (4,3,5).
Example 2:

Input: n = 10
Output: 4
Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
 

Constraints:

1 <= n <= 250


class Solution {
   public int countTriples(int limit)
    {
        int result = 0;
        int x = (int)Math.sqrt(limit);
        for (int m = 2; m <= x; m++)
        {
            int mSquare = m * m;
            for (int n = 1; n < m; n++)
            {
                if (m % 2 + n % 2 == 1 && gcd(m, n) == 1)
                {
                    int c = mSquare + n * n;
                    if (c <= limit)
                    {
                        result += limit / c;
                    }
                }
            }
        }

        return result * 2;
    }

    private int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}