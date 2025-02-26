720. Longest Word in Dictionary
Solved
Medium
Topics
Companies
Hint
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.


class Solution {
	private TreeNode root;
	private String result = "";

	public String longestWord(String[] words) {
		root = new TreeNode();

		for (String w : words)
			insert(w);

		dfs(root);

		return result;
	}

	private void dfs(TreeNode node) {
		if (node == null)
			return;

		if (node.word != null) {
			if (node.word.length() > result.length())
				result = node.word;
			else if (node.word.length() == result.length() && node.word.compareTo(result) < 0)
				result = node.word;
		}

		for (TreeNode child : node.children)
			if (child != null && child.word != null)
				dfs(child);
	}

	private void insert(String word) {
		TreeNode current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new TreeNode();
			current = current.children[c - 'a'];
		}
		current.word = word;
	}

}

class TreeNode {
	TreeNode[] children = new TreeNode[26];
	String word;

	TreeNode () {}
}
