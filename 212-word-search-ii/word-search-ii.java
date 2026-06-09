class Solution {
    boolean[][] vis;
    HashSet<String> hs = new HashSet<>();
    char[][] board;
    trienode root= new trienode();

    class trienode{
        trienode[] child;
        boolean eow;

        public trienode(){
            child=new trienode[26];
            eow=false;
        }
        void insert(String[] words){
            for(var s:words){
                trienode curr=root;

                for(char c:s.toCharArray()){
                    int ind=c-'a';
                    if(curr.child[ind]==null) curr.child[ind]=new trienode();

                    curr=curr.child[ind];
                }
                curr.eow=true;
            }
        }
    }
    void search(int i , int j ,trienode curr , StringBuilder sb){
        if(i<0 ||j<0 || i>=vis.length || j>= vis[0].length || vis[i][j]) return;
        int ind=board[i][j]-'a';
        if(curr.child[ind]==null) return ;

        vis[i][j]=true;
        int l =sb.length();
        sb.append(board[i][j]);

        curr=curr.child[ind];
        if(curr.eow) hs.add(new String(sb.toString()));
        
        search(i+1,j,curr,sb);
        search(i,j+1,curr,sb);
        search(i-1,j,curr,sb);
        search(i,j-1,curr,sb);
        sb.setLength(l);
        vis[i][j]=false;

    }
    public List<String> findWords(char[][] board, String[] words) {
        root.insert(words); 
        this.board=board;

        int m= board.length;
        int n= board[0].length;
        vis= new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c= board[i][j];
                int ind= c-'a';

                if(root.child[ind]!=null) search(i , j , root , new StringBuilder());
            }
        }
        return new ArrayList<>(hs);
    }
}