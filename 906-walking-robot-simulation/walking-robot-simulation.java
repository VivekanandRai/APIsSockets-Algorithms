class Solution {

    record point(int x, int y){};

    public int robotSim(int[] commands, int[][] obstacles) {
        int maxdist=0;
        int[][] dirn={{0,1},{1,0},{0,-1},{-1,0}};
        HashSet<point> hs= new HashSet<>();
        for(int[] a: obstacles)  hs.add(new point(a[0],a[1]));

        int[] curr={0,0};

        int head=0;
        for(int i:commands){
            if(i==-2) head= (head+3)%4;
            else if(i==-1) head=(head+1)%4;
            else{
                while(i >0){
                    i--;
                    int[] d= dirn[head];//direction vector

                    int xx=curr[0]+d[0];
                    int yy=curr[1]+d[1];
                    if(hs.contains(new point(xx,yy))) break;

                    curr[0]=xx;curr[1]=yy;
                    maxdist=Math.max(maxdist,curr[0]*curr[0]+curr[1]*curr[1]);
                }
            }
        }

        return maxdist;
    }
}