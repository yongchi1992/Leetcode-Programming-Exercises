import java.util.HashMap;

/**
 * Created by yongchizhang on 17/8/20.
 */


//HashMap<Character, xxx>  是没用的

class Trie2 {

    class Node{
        String prefix;
        Node[] map;
        boolean isWord;
        Node(String prefix){
            this.prefix = prefix;
            map = new Node[26];
            isWord = false;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new Node("");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.map[c - 'a'] == null){
                cur.map[c - 'a'] = new Node(word.substring(0, i + 1) );
            }
            cur = cur.map[c - 'a'];
            if(i == word.length() - 1){
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.map[c - 'a'] == null){
                return false;
            }
            cur = cur.map[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.map[c - 'a'] == null){
                return false;
            }
            cur = cur.map[c - 'a'];
        }
        return true;
    }
}




class Trie {

    class Node{
        String prefix;
        HashMap<Character, Node> map;
        boolean isWord;
        Node(String prefix){
            this.prefix = prefix;
            map = new HashMap<>();
            isWord = false;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node("");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.map.containsKey(c)){
                cur.map.put(c, new Node(word.substring(0, i + 1) ) );
            }
            cur = cur.map.get(c);
            if(i == word.length() - 1){
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.map.containsKey(c)){
                return false;
            }
            cur = cur.map.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

