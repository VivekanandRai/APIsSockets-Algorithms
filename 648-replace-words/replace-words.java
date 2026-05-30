class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] str= sentence.split(" ");

        trie root= new trie();
        for(var s:dictionary) root.insert(s);

        for(int i=0;i<str.length;i++){
            String s= str[i];
            String temp=root.findroot(s);
            str[i]=temp;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<str.length;i++){
            String s= str[i];
            sb.append(s);
            if(i==str.length-1) return sb.toString();
            sb.append(" ");
        }
        return sb.toString();

    }

    class trie{
        trie[] child;
        boolean eow;

        public trie(){
            child=new trie[26];
            eow=false;
        }
        void insert(String ip){
            trie curr= this;
            for(char c:ip.toCharArray()){
                int ind= c-'a';
                if(curr.child[ind]==null) curr.child[ind]=new trie();
                curr=curr.child[ind];
            }
            curr.eow=true;
        }
        boolean search(String ip){
            trie curr= this;
            for(char c:ip.toCharArray()){
                int ind= c-'a';
                if(curr.child[ind]==null) return false;
                curr=curr.child[ind];
            }
            return curr.eow;
        }
        boolean startswith(String ip){
            trie curr= this;
            for(char c:ip.toCharArray()){
                int ind= c-'a';
                if(curr.child[ind]==null) return false;
                curr=curr.child[ind];
            }
            return true;
        }
        String findroot(String ip){
            trie curr= this;
            StringBuilder sb = new StringBuilder();
            for(char c:ip.toCharArray()){
                int ind= c-'a';

                if(curr.child[ind]!=null){
                    sb.append(c);
                     curr=curr.child[ind]; //next pointer
                    if(curr.eow) return sb.toString();//we got the shortest root for this word
                   
                }else break;
            }
            return ip;
        }

    }
}