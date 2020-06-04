package may14;

/**
Class representing basic data structure
**/
class TrieNode{
     TrieNode[] children= new TrieNode[26];
     boolean isLeaf;    
    }
   

class Trie {
    private final TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {   
    
        if(word.isEmpty())
            return; 

        TrieNode current=root;        
        for(int i=0;i<word.length();i++){
            int index= getIndex(word.charAt(i));  
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
         current.isLeaf=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.isEmpty())
            return false;
        
        TrieNode current=root;
        for(int i=0;i<word.length();i++){
        int index= getIndex(word.charAt(i));
        if(current.children[index]==null){
            return false;
        }
        else{
                current=current.children[index];
        }
    }
        return current.isLeaf;   
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {  
         if(prefix.isEmpty())
            return false;
        TrieNode current=root;
        for(int i=0;i<prefix.length();i++){
        int index= getIndex(prefix.charAt(i));
        if(current.children[index]==null){
            return false;
        }
        else{
                current=current.children[index];
            }
        
    }
        return true;
    }
    
    private int getIndex(char c){
        return c-'a';
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */