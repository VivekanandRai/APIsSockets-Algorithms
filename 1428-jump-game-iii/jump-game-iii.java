class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> ind = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                ind.add(i);
            }
        }


        if(arr[start]==0) return true;//edge case

        int l=arr.length;
        boolean[] vis= new boolean[l];

        Queue<Integer> q= new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr=q.poll();
            if(vis[curr]) continue;
            vis[curr]=true;

            int anext=curr+arr[curr];
            int bnext=curr-arr[curr];

            if(ind.contains(anext) ||ind.contains(bnext)) return true;

            if(!(anext<0 || anext>=l)) q.add(anext);
            if(!(bnext<0 || bnext>=l)) q.add(bnext);
        }
        return false;
    }
}