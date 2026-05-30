class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        trie a = new trie();
        int idx1=0;
        for(var s: wordsContainer){
            a.insert(s,idx1++);
        }
        int[] res= new int[wordsQuery.length];
        int idx=0;
        for(String s :wordsQuery){
            res[idx++]=a.findidx(s);
        }
        return res;
        
    }
    class trie{
        trie[] child;
        boolean eow;
        int index;
        int maxlen;
        public trie(){
            child= new trie[26];
            eow=false;
            index=0;
            maxlen=5000;
        }
        void update(int len, int idx){
            if(len < maxlen ){
                maxlen = len;
                index = idx;
            }
        }

        void insert(String s , int idx){
            trie curr= this;

            curr.update(s.length(), idx); // root

            for(char c: reverse(s).toCharArray()){
                int ind= c-'a';
                if(curr.child[ind]==null) {
                    curr.child[ind]=new trie();
                    curr.child[ind].index=idx;
                }
                curr=curr.child[ind];
                curr.update(s.length() , idx);
                
                
            }
            curr.eow=true;
        }

        int findidx(String s ){
            trie curr= this;
            for(char c: reverse(s).toCharArray()){
                int ind= c-'a';
                if(curr.child[ind]==null){
                    return curr.index;
                }
                curr=curr.child[ind];
            }
            return curr.index;
        }

    }
    String reverse(String s){
        var sb= new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}