class WordDictionary {
    WordDictionary[] child;
    boolean eow;

    public WordDictionary() {
        child= new WordDictionary[26];
        eow=false;
    }
    
    public void addWord(String word) {
        WordDictionary curr=this;
        for(char c:word.toCharArray()){
            int ind=c-'a';
            if(curr.child[ind]==null) curr.child[ind]=new WordDictionary();
            curr=curr.child[ind];
        }
        curr.eow=true;
    }
    boolean find(char[] wordchar ,int index , WordDictionary curr){
        //if(index>=wordchar.length) return false;

        for(int i= index;i<wordchar.length;i++){
            if(wordchar[i]=='.'){
                boolean flag=false;
                for(int k=0;k<26;k++){
                    if(curr.child[k]!=null){
                        flag= flag||find(wordchar ,i+1 ,curr.child[k]);
                    }
                }
                return flag;
            }

            int ind= wordchar[i]-'a';
            if(curr.child[ind]==null) return false;
            curr=curr.child[ind];
        }
        return curr.eow;
    }
    
    public boolean search(String word) {
        WordDictionary curr= this;

        return find(word.toCharArray() ,0 , curr);
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */