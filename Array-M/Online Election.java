911. Online Election
Solved
Medium
Topics
premium lock icon
Companies
You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].

For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.

Implement the TopVotedCandidate class:

TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
 

Example 1:

Input
["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
Output
[null, 0, 1, 1, 0, 0, 1]

Explanation
TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
topVotedCandidate.q(15); // return 0
topVotedCandidate.q(24); // return 0
topVotedCandidate.q(8); // return 1

 

Constraints:

1 <= persons.length <= 5000
times.length == persons.length
0 <= persons[i] < persons.length
0 <= times[i] <= 109
times is sorted in a strictly increasing order.
times[0] <= t <= 109
At most 104 calls will be made to q.


class TopVotedCandidate {
int []nums;
int []tim;
    public TopVotedCandidate(int[] num, int[] times) {
        this.nums=new int[num.length];
        this.tim=times;
        Map<Integer,Integer>map=new HashMap<>();
        int temp=-1,max=-1;
        for(int i=0;i<nums.length;i++){
            int p=num[i];
            map.put(p,map.getOrDefault(p,0)+1);
            if(temp==-1||map.get(p)>=max){
                temp=p;
                max=map.get(p);
            }
            nums[i]=temp;
        }
    }
    
    public int q(int t) {
        return nums[bi(tim,t)];
    }
    public int bi(int arr[],int t){
        int i=0,j=arr.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]==t)return mid;
            else if(arr[mid]<t)i=mid+1;
            else j=mid-1;
        }
        return j;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
