class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->(b[1]-b[0])-(a[1]-a[0]));
        
        int r= 1000000000;
        int l=0;
        //int ans=r;
        while(l<=r){
            int m=l+(r-l)/2;

            if(pass(m ,tasks)){
                r=m-1;
                continue;
            }else{
                l=m+1;
                continue;
            }
        }
        return l;

    }

    boolean pass(int m , int[][] tasks){
        for(int[] t:tasks){
            if(m<t[1]) return false;
            m=m-t[0];
        }
        return true;
    }
}