692. Top K Frequent Words
Solved
Medium
Topics
Companies
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]


import java.util.*;

class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = null;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }

    public void getWords(TrieNode node, List<String> result) {
        if (node == null)
            return;
        if (node.word != null)
            result.add(node.word);
        for (TrieNode child : node.children) {
            if (child != null) {
                getWords(child, result);
            }
        }
    }

    // Added method to expose root
    public TrieNode getRoot() {
        return root;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<Trie> buckets = new ArrayList<>(Collections.nCopies(words.length + 1, null));
        List<String> topK = new ArrayList<>();

        // Count word frequencies
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Add words to buckets based on frequency
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            if (buckets.get(freq) == null) {
                buckets.set(freq, new Trie());
            }
            buckets.get(freq).addWord(word);
        }

        // Retrieve top k words from buckets
        for (int i = buckets.size() - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets.get(i) != null) {
                List<String> wordsInBucket = new ArrayList<>();
                // Use the new getRoot method
                buckets.get(i).getWords(buckets.get(i).getRoot(), wordsInBucket);

                // Sort words in lexicographical order
                Collections.sort(wordsInBucket);

                // Add words from the bucket to the result until top k is filled
                for (String word : wordsInBucket) {
                    if (topK.size() < k) {
                        topK.add(word);
                    } else {
                        break;
                    }
                }
            }
        }

        return topK;
    }
}
