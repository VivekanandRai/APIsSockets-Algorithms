class Solution {
    int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m= grid.size();
        int n=grid.get(0).size();

        int[][] hmat = new int[m][n];
        for(int[] h : hmat) Arrays.fill(h , Integer.MIN_VALUE);

        //var pq= new ArrayDeque<int[]>();
        var pq = new PriorityQueue<int[]>((a,b)->b[2]-a[2]);
        
        if(grid.get(0).get(0)==1) health--;

        pq.add(new int[]{0,0,health});
        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int x= curr[0];
            int y= curr[1];
            int h= curr[2];

            if(h<1) continue;
            if(x==m-1 && y==n-1 && hmat[x][y]>0) return true;

            for( int[] d :dir){
                int nx= x+d[0];
                int ny=y+d[1];
                int nh=h;
                
                if(nx>=0 && ny>=0 && nx< m && ny < n && hmat[nx][ny]< nh ){
                    if(grid.get(nx).get(ny)==1) nh--;

                    if(hmat[nx][ny]>= nh) continue;

                    hmat[nx][ny]= Math.max(hmat[nx][ny] , nh);
                    pq.add(new int[]{nx, ny , hmat[nx][ny]});

                }
            }
        }
        return false;

    }
}