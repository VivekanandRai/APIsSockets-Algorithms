class Solution {
    int mod=1000000007;

    public int assignEdgeWeights(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<edges.length+2;i++) adj.add(new ArrayList<>());

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis= new boolean[adj.size()];

        var q= new ArrayDeque<Integer>();
        q.add(1);
        int lvl=0;
        while(!q.isEmpty()){
            int size=q.size();
            lvl++;
            while(size-->0){
                int node= q.removeFirst();
                vis[node]=true;

                for(int n :adj.get(node)){
                    if(!vis[n]) q.addLast(n);
                }
            }
        }
        int depth= lvl-1;
        int ans=1;
        for(int i=1;i<=depth-1;i++){
            ans=(ans*2)%mod;
        }
        return ans;
    }

}