/**
 * Created by yongchizhang on 17/8/20.
 */
public class Trie_AddAndSearchWord {
    class WordDictionary {

        class Node{
            String prefix;
            Node[] map;
            boolean isWord;
            Node(String prefix){
                this.prefix = prefix;
                this.map = new Node[26];
                this.isWord = false;
            }
        }

        Node root;


        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node("");
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.map[c - 'a'] == null){
                    cur.map[c - 'a'] = new Node(word.substring(0, i + 1));
                }
                cur = cur.map[c - 'a'];
                if(i == word.length() - 1){
                    cur.isWord = true;
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            Node cur = root;
            return dfs(word, cur, 0);
        }

        public boolean dfs(String word, Node cur, int idx) {
            while(idx < word.length() && word.charAt(idx) != '.' ){
                char c = word.charAt(idx);
                if(cur.map[c - 'a'] == null){
                    return false;
                }
                cur = cur.map[c - 'a'];
                idx++;
            }
            if(idx == word.length()){
                return cur.isWord;
            }
            for(int i = 0; i < 26; i++){
                if(cur.map[i] == null){
                    continue;
                }
                Node tmp = cur.map[i];
                if(dfs(word, tmp, idx + 1)){
                    return true;
                }
            }
            return false;
        }
    }
}
