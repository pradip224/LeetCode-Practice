622. Design Circular Queue
Solved
Medium
Topics
Companies
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Implement the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 

 

Example 1:

Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
 

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.




class MyCircularQueue {
    private int queue[]; // queue , using array
    private int front; // front pointer , for dequeue
    private int rear; // rear pointer , for enqueue
    private int n; // size of queue

    // intialize queue 
    public MyCircularQueue(int k) {
        // intialize queue size and queue array
        // intially both front and rear equal to -1 ie no elements in the queue yet
        n = k;
        queue = new int[n];
        front = rear = -1;
    }
    
    // enqueue element 
    public boolean enQueue(int value) {
        if((rear + 1) % n == front) return false; // overflow

        // if queue is empty
        if(rear == -1) {
            // increment both
            front++;
            rear++;
        }
        else {
            // increment rear , MOD n to rotate across the array 
            rear = (rear + 1) % n;
        }
        queue[rear] = value;
        return true;
    }
    
    // dequeue element
    public boolean deQueue() {
        if(front == -1) return false; // underflow

        // if queue has a single element
        if(front == rear) {
            front = rear = -1;
        }
        else {
            // increment front , MOD n to rotate across the array
            front = (front + 1) % n;
        }
        return true;
    }
    
    // get element at front
    public int Front() {
        if(front == -1) return -1; // if queue is empty
        return queue[front];
    }
    
    // get element at rear
    public int Rear() {
        if(rear == -1) return -1; // if queue is empty
        return queue[rear];
    }
    
    // queue is Empty
    public boolean isEmpty() {
        if(front == -1) return true; 
        return false;
    }
    
    // queue is full
    public boolean isFull() {
        return (rear + 1) % n == front; // overflow 
    }
}
