class Solution {
    public int findMaximumXOR(int[] nums) {
        trie root= new trie();
        for(int n:nums) root.insert(n);

        int res=0;
        for(int n:nums){
            res=Math.max(res, n^root.maxxor(n));
        }
        return res;

    }
    class trie{
        trie[] child;
        boolean eow;

        public trie(){
            child= new trie[2];
            eow=false;
        }
        void insert(int number){
            trie curr=this;

            int copy= number;
            for(int i=31;i>=0;i--){
                int bit=(copy>>i)&1;
                if(curr.child[bit]==null) curr.child[bit]= new trie();
                curr=curr.child[bit];
            }
            curr.eow=true;
        }

        int maxxor(int number){
            trie curr= this;

            int ans=0;

            for(int i=31;i>=0;i--){
                int bit= (number>>i) &1;
                ans=ans<<1;

                int desiredbit=bit^1;

                if(curr.child[desiredbit]!= null){
                    curr= curr.child[desiredbit];
                    ans=ans|(desiredbit);
                }else{
                    curr= curr.child[bit];
                    ans=ans|(bit);
                }
            }
            return ans;
        }
    }
}