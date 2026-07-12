class Solution {
    int MOD= 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int l = s.length();

        int[] cnt= new int[l+1];
        long[] power= new long[l+1];
        int[] sum=new int[l+1];
        power[0]=1;
        for(int i=1;i<power.length;i++){
            power[i]=(power[i-1]*10)%MOD;
            sum[i]=sum[i-1]+(s.charAt(i-1)-'0');
        }
        long[] value= new long[l+1];


        for(int i=1;i<=s.length();i++){
            char c= s.charAt(i-1);

            if(c=='0'){
                value[i]= value[i-1];
                cnt[i]=cnt[i-1];
                continue;
            }

            int digit= c-'0';
            value[i]= ((value[i-1]*10)% MOD + digit)%MOD ;
            cnt[i]=cnt[i-1]+1;
        }


        int[] res= new int[queries.length];
        int ind=0;
        for(int[] q:queries){
            int left=q[0];
            int ryt=q[1];

            int digsum=sum[ryt+1]-sum[left];
            int places=cnt[ryt+1]-cnt[left];

            long x1= value[ryt+1];
            long x2=(value[left]*power[places])%MOD;

            long diff = (x1 - x2 + MOD) % MOD;
            res[ind++] = (int)((diff * digsum) % MOD);
        }
        return res;


    }
}