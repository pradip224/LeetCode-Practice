722. Remove Comments
Solved
Medium
Topics
Companies
Hint
Given a C++ program, remove comments from it. The program source is an array of strings source where source[i] is the ith line of the source code. This represents the result of splitting the original source code string by the newline character '\n'.

In C++, there are two types of comments, line comments, and block comments.

The string "//" denotes a line comment, which represents that it and the rest of the characters to the right of it in the same line should be ignored.
The string "/*" denotes a block comment, which represents that all characters until the next (non-overlapping) occurrence of "*/" should be ignored. (Here, occurrences happen in reading order: line by line from left to right.) To be clear, the string "/*/" does not yet end the block comment, as the ending would be overlapping the beginning.
The first effective comment takes precedence over others.

For example, if the string "//" occurs in a block comment, it is ignored.
Similarly, if the string "/*" occurs in a line or block comment, it is also ignored.
If a certain line of code is empty after removing comments, you must not output that line: each string in the answer list will be non-empty.

There will be no control characters, single quote, or double quote characters.

For example, source = "string s = "/* Not a comment. */";" will not be a test case.
Also, nothing else such as defines or macros will interfere with the comments.

It is guaranteed that every open block comment will eventually be closed, so "/*" outside of a line or block comment always starts a new comment.

Finally, implicit newline characters can be deleted by block comments. Please see the examples below for details.

After removing the comments from the source code, return the source code in the same format.

 

Example 1:

Input: source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
Output: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
Explanation: The line by line code is visualized as below:
/*Test program */
int main()
{ 
  // variable declaration 
int a, b, c;
/* This is a test
   multiline  
   comment for 
   testing */
a = b + c;
}
The string /* denotes a block comment, including line 1 and lines 6-9. The string // denotes line 4 as comments.
The line by line output code is visualized as below:
int main()
{ 
  
int a, b, c;
a = b + c;
}
Example 2:

Input: source = ["a/*comment", "line", "more_comment*/b"]
Output: ["ab"]
Explanation: The original source string is "a/*comment\nline\nmore_comment*/b", where we have bolded the newline characters.  After deletion, the implicit newline characters are deleted, leaving the string "ab", which when delimited by newline characters becomes ["ab"].
 

Constraints:

1 <= source.length <= 100
0 <= source[i].length <= 80
source[i] consists of printable ASCII characters.
Every open block comment is eventually closed.
There are no single-quote or double-quote in the input.


class Solution {
    public List<String> removeComments(String[] source) {
        boolean blockActive = false; //We keep track of whether or not we are within a block comment with the blockActive variable. 
		//It is initally set to false since we haven't read anything until now. 


        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        
        //Read every line from the source input. 
        
        for(String line: source){
// Each time we move on to reading a new line, we check if it is a part of a block comment. 
//If it is already part of a block comment, it means we should skip the implicit newline characters as mentioned in the problem description. 
//For example if Line 1 was  "int a /*Block comment Started" and Line 2 was "Block comment ends here */ b;", and Line 3 was "int c;" 
//we want our output to be "int ab", "int c" instead of "int a", "b;", "int c;" 
            if(!blockActive){ 
                builder = new StringBuilder();
            }
            for(int i=0; i<line.length(); i++){ //Read every character of line
                char c = line.charAt(i);
                if(!blockActive){ //If we aren't currently in a block
                    
                    if(c=='/'){ //We check if we encounter the start of a regular comment
                        //If so, then we need to check if the next character makes it a regular comment, a block comment, or neither of those two. 
                        
                        if(i<line.length()-1 && line.charAt(i+1)=='/'){ //Checking if it's a regular comment
                            break; //If it's a regular comment, we can simply skip everything else 
							//until the end of the line, so we break from the loop and move on to the next line.
                        } else if(i<line.length()-1 && line.charAt(i+1)=='*'){ //Or a block comment
                            i++; //Since we verified it's a block comment, we simply increment i so that we don't re-read the '*' again, 
							//and mark that we are now part of a block comment. 
                            blockActive = true;
                        } else{ // If the second character is neither a / or *, it indicates that a first character must be a valid operator 
						//(probably a mathematical operator such as multiplication or division, and not part of any comment, 
						//so simply append it to the builder)
                            builder.append(c);
                        }
                    } else  { //Append all other characters directly to the builder. 
                        builder.append(c);
                    }
                } else {
                    //We skip all other characters in a block comment, and check for the closing block comment. 
					//Once we find it, we mark the blockActive variable as false to indicate that it isn't part of the block anymore.  
                    if(c=='*'){
                        if(i<line.length()-1 && line.charAt(i+1)=='/'){
                              blockActive = false;  
                              i++;
                        }
                    }
                } 
            }
            //We append to the result when we aren't part of a block any more, and the builder contains 1 or more characters. 
            if(!blockActive && builder.length()!=0){
                result.add(builder.toString());
            }
            
        }
        
        return result;
        
    }
}
