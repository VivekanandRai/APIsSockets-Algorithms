class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        HashMap<Integer , ArrayList<int[]>> adj= new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new int[]{v,w});
        }
        char[] label= labels.toCharArray();

        
        int[][] dist= new int[n][k+1];//2 state djisktra(cost of path , streak used)
        for(int[] d:dist) Arrays.fill(d,Integer.MAX_VALUE);

        
        var pq= new PriorityQueue<int[]>((a,b)->a[1]-b[1]);// (node , wt , streak)
        pq.add(new int[]{0 , 0 , 1});
        dist[0][1]=0;

        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int u=curr[0], w=curr[1] ,s=curr[2];

            if(adj.get(u).size()==0) continue;
            
            for(int[] nei :adj.get(u)){
                int v= nei[0];
                int nw=w+nei[1];
                int ns=1;
                if(label[u]==label[v]) ns=s+1;
                if(ns>k) continue;

                if(nw < dist[v][ns]){
                    dist[v][ns]=nw;
                    pq.add(new int[]{v,nw,ns});
                }

            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            ans=Math.min(dist[n-1][i] ,ans);
        }
        return ans==Integer.MAX_VALUE? -1: ans;
    }
}