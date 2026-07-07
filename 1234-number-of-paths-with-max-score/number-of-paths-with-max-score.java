class Solution {
    int MOD= 1000000007;
    char[][] mat;
    Integer[][][] dp;
    public int[] pathsWithMaxScore(List<String> board) {
        int len= board.size();
        int column=board.get(0).length();
        dp=new Integer[len][column][2];
        mat= new char[len][column];

        int i=0;
        for(String s : board){
            mat[i++]= s.toCharArray();
        }
        if(mat[len-1][column-1]=='X' || mat[0][0]=='X') return new int[]{0,0};
        mat[0][0]='0';
        mat[len-1][column-1]='0';

        Integer[] ans = f(0, 0 );
        if(ans[0]==Integer.MIN_VALUE) return new int[]{0,0};
        return new int[]{ ans[0], ans[1]};
    }

    Integer[] f(int r , int c ){
        if(r>=mat.length || c>= mat[0].length ||mat[r][c]=='X') return new Integer[]{Integer.MIN_VALUE,0};
        if(r==mat.length-1 && c==mat[0].length-1) return dp[r][c]=new Integer[]{0,1};//basecase

        char ch= mat[r][c];
        int curr= ch-'0';

        if(dp[r][c][0]!=null) return dp[r][c];
        
        Integer[] x= f(r , c+1);
        Integer[] y= f(r+1, c);
        Integer[] z= f(r+1 , c+1); 

        Integer[] ans = process(x,y,z);
        if(ans[0]==Integer.MIN_VALUE) return dp[r][c]= new Integer[]{Integer.MIN_VALUE,0};

        return dp[r][c]=new Integer[]{ ans[0]+curr ,ans[1]};
    }

    Integer[] process(Integer[] x, Integer[] y , Integer[] z){
        int max= Math.max(x[0] , Math.max(y[0] , z[0]));

        if(max==Integer.MIN_VALUE) return new Integer[]{max , 0};
        int freq=0;
        if(x[0]==max) freq= (freq%MOD + x[1]%MOD)%MOD;
        if(y[0]==max) freq= (freq%MOD +y[1]%MOD)%MOD;
        if(z[0]==max) freq= (freq%MOD +z[1]%MOD)%MOD;
        return new Integer[]{max , freq};
    }
}