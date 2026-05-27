class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] ch= s.toCharArray();
        int l=ch.length;
        int[] t= new int[l];
        t[0]=1;

        int count=0;
        for(int i=1;i<l;i++){

            if(i-maxJump-1>=0){
                count-=t[i-maxJump-1];
            }
            if( i-minJump>=0){
                count+=t[i-minJump];
            }
            if(count>0 && ch[i]=='0'){
                t[i]=1;
            }
        }
        return t[l-1]>0;
    }
}