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

            if(dq.peekLast()[2]==1 && node[2]==-1){
                if(dq.peekLast()[1]>node[1]){
                    int[] popped= dq.pollLast();
                    popped[1]=popped[1]-1;
                    dq.offerLast(popped);
                    continue;
                }else if(dq.peekLast()[1]==node[1]){
                    dq.pollLast();
                    continue;
                }else{
                    while(!dq.isEmpty() && dq.peekLast()[1]<node[1] && dq.peekLast()[2]==1){
                        dq.pollLast();
                        node[1]=node[1]-1;
                    }
                    if(dq.isEmpty()) {
                        dq.add(node);continue;
                    }

                    if(dq.peekLast()[2]==-1){//top node is going left=all good
                        dq.offerLast(node);
                        continue;
                    }else{
                        int[] top = dq.pollLast();

                        if(top[1] > node[1]){
                            top[1]--;
                            dq.offerLast(top);
                            continue;
                        } else if(top[1] == node[1]){
                            continue; // both destroyed
                        } else {
                            node[1]--;
                            // continue collision with next elements
                            while(!dq.isEmpty() && dq.peekLast()[2]==1 && dq.peekLast()[1] < node[1]){
                                dq.pollLast();
                                node[1]--;
                            }

                            if(dq.isEmpty() || dq.peekLast()[2]==-1){
                                dq.offerLast(node);
                            } else {
                                int[] t = dq.pollLast();
                                if(t[1] > node[1]){
                                    t[1]--;
                                    dq.offerLast(t);
                                } else if(t[1] < node[1]){
                                    node[1]--;
                                    dq.offerLast(node);
                                }
                            }
                        }
                    }
                }
            }

            dq.addLast(node);
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