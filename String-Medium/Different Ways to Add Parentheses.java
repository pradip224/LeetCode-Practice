Different Ways to Add Parentheses
Medium
4.8K
232
Companies
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

 

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);

                List<Integer> leftResults = compute(leftExpr, memo);
                List<Integer> rightResults = compute(rightExpr, memo);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int result = 0;

                        switch (ch) {
                            case '+':
                                result = left + right;
                                break;
                            case '-':
                                result = left - right;
                                break;
                            case '*':
                                result = left * right;
                                break;
                        }

                        results.add(result);
                    }
                }
            }
        }

        // If the expression is a single number, add it to the results
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }
}
