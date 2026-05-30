class Trie {
    Trie[] child;
    boolean eow;

    public Trie() {
        child= new Trie[26];
        eow=false;
    }
    
    public void insert(String word) {
        Trie curr= this;
        for(char c:word.toCharArray()){
            int ind= c-'a';
            if(curr.child[ind]==null) curr.child[ind]=new Trie();

            curr=curr.child[ind];
        }
        curr.eow=true;

    }
    
    public boolean search(String word) {
        Trie curr=this;
        for(char c:word.toCharArray()){
            int ind=c-'a';
            if(curr.child[ind]==null) return false;

            curr=curr.child[ind];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        for(char c:prefix.toCharArray()){
            int ind=c-'a';
            if(curr.child[ind]==null) return false;

            curr=curr.child[ind];
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