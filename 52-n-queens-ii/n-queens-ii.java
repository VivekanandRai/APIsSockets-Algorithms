class Solution {
    Character[][] b;
    int res=0;
    public int totalNQueens(int n) {
        b= new Character[n][n];

        dfs(b,0);
        return res;

        
    }
    //rowwise dfs
    void dfs(Character[][] b, int i ){
        if(i>= b.length ) return ;

        for(int col=0;col<b.length;col++){
            b[i][col]='*';
            if(verify(b,i,col)){
                if(i==b.length-1){
                    res++;
                }else{
                    dfs(b,i+1);
                }
            }
            b[i][col]=null;
        }
    }

    boolean verify(Character[][] b, int i , int j){
        //vertical
        for(int row=0;row<b.length;row++){
            if(row==i) continue;
            if(b[row][j]!=null) return false;
        }

        //horizontal
        for(int c=0;c<b.length;c++){
            if(c==j) continue;
            if(b[i][c]!=null) return false;
        }

        //diagonal up
        int r=i-1;
        int c=j+1;
        while(r>=0 && c<b.length){
            if(b[r][c]!=null) return false;
            r--;
            c++;
        }

        r=i+1;
        c=j-1;
        while(r<b.length && c>=0){
            if(b[r][c]!=null) return false;
            r++;
            c--;
        }

        r=i-1;
        c=j-1;
        while(r>=0 && c>=0){
            if(b[r][c]!=null) return false;
            r--;
            c--;
        }
        r=i+1;
        c=j+1;
        while(r<b.length && c<b.length){
            if(b[r][c]!=null) return false;
            r++;
            c++;
        }

        return true;


    }
}