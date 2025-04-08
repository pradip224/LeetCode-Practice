835. Image Overlap
Solved
Medium
Topics
Companies
You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.

Return the largest possible overlap.

 

Example 1:


Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

Example 2:

Input: img1 = [[1]], img2 = [[1]]
Output: 1
Example 3:

Input: img1 = [[0]], img2 = [[0]]
Output: 0
 

Constraints:

n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] is either 0 or 1.
img2[i][j] is either 0 or 1.


class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int R1 = img1.length;
        int R2 = img2.length;
        int C1 = img1[0].length;
        int C2 = img2[0].length;
        int max = Integer.MIN_VALUE;
		
		//Slide one image on other image.
        for(int r=0; r<R1+R2-1; r++){
            int i = R1-1 + Math.min(0, R2-1-r);
            int x = r + Math.min(0, R2-1-r);
            for(int c=0; c<C1+C2-1;  c++){
                int j = C1-1 + Math.min( 0 ,  C2-1-c);
                int y = c + Math.min(0 , C2-1-c);
                max = Math.max(max, overlap(img1,img2,i,j,x,y));
            }
        }
        return max;
    }
    
	//Compares two matrices from give coordinates to LEFT-TOP
    int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
        for(int i=i1,x=i2; i>=0 && x>=0; i--,x--){
            for(int j=j1, y=j2; j >=0 && y>=0 ; j--,y--){
                if(img1[i][j] == img2[x][y]){
                    if(img1[i][j]==1)
                        count++;
                }
            }
        }
        //System.out.println("[" + i1+" , "+j1+"]    ["+ i2 + " , "+j2+" ]" + "===" + count);
        return count;
    }
}
