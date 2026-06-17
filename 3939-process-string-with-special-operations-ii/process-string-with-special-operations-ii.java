class Solution {
    public char processStr(String s, long k) {
        long sbl=0;

        for(char c:s.toCharArray()){
            if(c >= 'a' && c <= 'z') sbl++;
            else if(c=='#') sbl<<=1;
            else if(c=='*'){
                if(sbl>0) sbl--;
            }
        }
        Character def='.';

        if(k>=sbl) return def;

        for(int i=s.length()-1;i>=0;i--){
            char c= s.charAt(i);

            if(c=='*'){
                sbl++;
            }else if(c=='%'){
                k= sbl-k-1;
            }else if(c=='#'){
                long half= sbl>>1;
                if(k>=half){
                    k=k-half;
                }
                sbl>>=1;
            }else{
                if(k==sbl-1) return c;
                else sbl--;
            }
        }
        return def;

    }
}