641. Design Circular Deque
Solved
Medium
Topics
Companies
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
 

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.


class MyCircularDeque {
    private int[] v;
    private int front, back, size, capacity;

    public MyCircularDeque(int k) {
        v = new int[k];
        Arrays.fill(v, -1); // Initialize the deque with -1
        front = 0;
        back = 0;
        size = 0; // Keeps track of the current number of elements
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        // Way - 01
        if (front == 0) {
            front = capacity - 1; // Wrap around to the end
        } else {
            front--; // Simply decrement front
        }

        // Way - 02 (Alternative method commented out)
        // front = (front - 1 + capacity) % capacity;

        v[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        v[back] = value;

        // Way - 01
        if (back == capacity - 1) {
            back = 0; // Wrap around to the beginning
        } else {
            back++; // Simply increment back
        }

        // Way - 02 (Alternative method commented out)
        // back = (back + 1) % capacity;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        v[front] = -1;

        // Way - 01
        if (front == capacity - 1) {
            front = 0; // Wrap around to the beginning
        } else {
            front++; // Simply increment front
        }

        // Way - 02 (Alternative method commented out)
        // front = (front + 1) % capacity;

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (back == 0) {
            back = capacity - 1; // Wrap around to the end
        } else {
            back--; // Simply decrement back
        }
        v[back] = -1;

        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return v[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (back == 0) {
            return v[capacity - 1]; // Wrap around to the last valid element
        } else {
            return v[back - 1]; // Get the last element
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
