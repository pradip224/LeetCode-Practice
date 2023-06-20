
Design Add and Search Words Data Structure
Medium
6.9K
391
Companies
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.




class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode getChild(char ch) {
        return children[ch - 'a'];
    }

    public TrieNode addChild(char ch) {
        int index = ch - 'a';
        if (children[index] == null) {
            children[index] = new TrieNode();
        }
        return children[index];
    }

    public TrieNode[] getChildren() {20
        return children;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.addChild(ch);
        }
        node.setWord();
    }

    public boolean search(String word) {
        return searchRecursive(word, root);
    }

    private boolean searchRecursive(String word, TrieNode node) {
        if (word.isEmpty()) {
            return node.isWord();
        }

        char ch = word.charAt(0);
        if (ch == '.') {
            TrieNode[] children = node.getChildren();
            for (TrieNode child : children) {
                if (child != null && searchRecursive(word.substring(1), child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.getChild(ch);
            if (child == null) {
                return false;
            }
            return searchRecursive(word.substring(1), child);
        }
    }
}
