class Solution {
    public int minScore(int n, int[][] roads) {
        var adj = new HashMap<Integer , ArrayList<int[]>>();
        for(int i=1;i<n+1;i++) adj.put(i , new ArrayList<int[]>());
        int minedge=Integer.MAX_VALUE;
        for(int[] r:roads){
            adj.get(r[0]).add(new int[]{r[1] , r[2]});
            adj.get(r[1]).add(new int[]{r[0] , r[2]});
        }
        var q = new ArrayDeque<int[]>();
        q.add(new int[]{1 , Integer.MAX_VALUE});

        boolean[] vis= new boolean[n+1];

        while(!q.isEmpty()){
            int[] curr= q.poll();
            int node=curr[0];
            int c=curr[1];

            minedge=Math.min(minedge , c);
            vis[node]=true;

            for(int[] nei : adj.get(node)){
                int nn= nei[0];
                int nc= nei[1];
                if(!vis[nn]){
                    q.add(new int[]{nn , nc});
                }
            }
        }

         return minedge;

        /*var pq = new PriorityQueue<int[]>((a,b)-> a[1]-b[1]);

        pq.add(new int[]{1,Integer.MAX_VALUE});

        int[] dist= new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0]=0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t= curr[0];
            int cost= curr[1];

            if(dist[t]<cost) continue;

            for(int[] nei : adj.get(t)){
                int nt= nei[0];
                int ncost= Math.min(cost , nei[1]);

                if(ncost>= cost || dist[nt]<ncost) continue;
                pq.add(new int[]{ nt , ncost});
                pq.add(new int[]{ t , ncost});
                dist[nt]=ncost;
                dist[t]= ncost;
            }
        }

        return dist[n];*/
    }
}