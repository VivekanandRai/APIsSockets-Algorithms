class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        char[] c= directions.toCharArray();
        var dq= new ArrayDeque<int[]>();

        int n= c.length;

        int[][] nodes= new int[n][4];
        for(int i=0;i<n;i++){
            int dir= c[i] =='R' ? 1:-1;
            nodes[i]=new int[]{positions[i] , healths[i] , dir ,i};
        }
        Arrays.sort(nodes, (a,b)->a[0]-b[0]);

        for(int[] node :nodes){
            if(dq.isEmpty()){
                dq.add(node);
                continue;
            }

            if(dq.peekLast()[2] == 1 && node[2] == -1){

                while(!dq.isEmpty() && dq.peekLast()[2] == 1){

                    int[] top = dq.peekLast();

                    if(top[1] < node[1]){
                        dq.pollLast();
                        node[1]--;
                    }
                    else if(top[1] == node[1]){
                        dq.pollLast();
                        node = null;
                        break;
                    }
                    else{
                        top[1]--;
                        node = null;
                        break;
                    }
                }

                if(node != null){
                    dq.offerLast(node);
                }
                continue;
            }else{
                dq.addLast(node);
            }
        }


        ArrayList<int[]> arl= new ArrayList<>();
        while(!dq.isEmpty()){
            arl.add(dq.pollLast());
        }

        Collections.sort(arl ,(a,b)->a[3]-b[3]);

        var ans= new ArrayList<Integer>();
        for(int i=0;i<arl.size();i++){
            ans.add(arl.get(i)[1]);
        }
        return ans;



    }
}