class Solution {
    Integer[] dp;
    HashMap<Integer, ArrayList<Integer>> hm=new HashMap<>();
    public int minJumps(int[] arr) {
        int l=arr.length;
        dp=new Integer[l];
        for(int i=0;i<l;i++){
            hm.computeIfAbsent(arr[i] , k-> new ArrayList()).add(i);
        }//index to indices(.....) MAPPING

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});//(index , operations performed to reach it)

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int index=curr[0];
            int op=curr[1];
            if(dp[index]!=null) continue;
            dp[index]=op; 

            if(index==l-1) return op;
            
            int ax=index+1;
            if(ax>=0 && ax<l) pq.add(new int[]{ax,op+1});
            int bx=index-1;
            if(bx>=0 && bx<l) pq.add(new int[]{bx,op+1});

            if(hm.containsKey(arr[index])){

                for(int x:hm.get(arr[index])){

                    if(dp[x]==null)
                        pq.add(new int[]{x,op+1});
                }

                // critical optimization
                hm.remove(arr[index]);
            }

        }
        return -1;
    }
}