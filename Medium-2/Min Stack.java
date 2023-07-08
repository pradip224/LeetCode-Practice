
Min Stack
Medium
12.1K
747
Companies
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.




import java.util.Stack;

class MinStack {
    private Stack<Integer> stack; // stack to store elements
    private Stack<Integer> minStack; // stack to keep track of minimum elements

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val); // push the element onto the main stack

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val); // push the element onto the min stack if it's smaller or equal to the current minimum
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop(); // if the element being popped is the current minimum, pop it from the min stack as well
        }

        stack.pop(); // pop the element from the main stack
    }

    public int top() {
        return stack.peek(); // return the top element of the main stack
    }

    public int getMin() {
        return minStack.peek(); // return the current minimum from the min stack
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 