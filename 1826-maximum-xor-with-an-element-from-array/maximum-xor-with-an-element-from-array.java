class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int res[] = new int[queries.length];
        trie root=new trie();

        int[][] nq=new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            nq[i][0]=queries[i][0];
            nq[i][1]=queries[i][1];
            nq[i][2]=i;
        }
        Arrays.sort(nq, (a,b)->a[1]-b[1]);

        int ptr=0;
        for(int i=0;i<nq.length;i++){
            int x=nq[i][0];
            int m=nq[i][1];
            int ind=nq[i][2];

            while(ptr<nums.length && nums[ptr]<=m){
                root.insert(nums[ptr]);
                ptr++;
            }
            if(ptr==0){
                res[ind]=-1;
                continue;
            }
            int xor=root.findmaxxor(x);

            res[ind]=xor;
        }
        return res;
    }

    class trie{
        trie[] child;
        boolean eow;
        int minnuminbranch;

        public trie(){
            child=new trie[2];
            eow=true;
            minnuminbranch=Integer.MAX_VALUE;
        }

        void insert(int number){
            trie curr=this;

            for(int i=31;i>=0;i--){
                int bit= (number>>i)&1;
                if(curr.child[bit]==null) curr.child[bit]=new trie();

                curr=curr.child[bit];
                if(curr.minnuminbranch>number) curr.minnuminbranch=number;
            }
            curr.eow=true;
        }

        int findmaxxor(int number){
            trie curr= this;

            int ans=0;

            for(int i=31;i>=0;i--){
                int bit= (number>>i)&1;
                int desired= bit^1 ;//opposite of current bit==> max number in result of xor
                ans=ans<<1;//leftshift for saving and formation

                if(curr.child[desired]!=null ){
                    ans= ans|1;
                    curr=curr.child[desired];

                }else{
                    curr=curr.child[bit];
                    ans=ans|0;
                }
            }
            return ans;
        }
    }


}