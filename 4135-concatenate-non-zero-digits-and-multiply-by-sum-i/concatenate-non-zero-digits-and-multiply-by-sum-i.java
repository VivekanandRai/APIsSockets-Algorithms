class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        var sb = new StringBuilder();
        while(n>0){
            int bit = n%10;
            sum+=bit;
            if(bit==0){
                n/=10;
                continue;
            }

            sb.insert(0 , bit );
            n/=10;
        }
        String res= sb.toString();
        if(res.length()==0) return 0L;
        long ans = Long.valueOf(res);
        return ans*sum;
    }
}