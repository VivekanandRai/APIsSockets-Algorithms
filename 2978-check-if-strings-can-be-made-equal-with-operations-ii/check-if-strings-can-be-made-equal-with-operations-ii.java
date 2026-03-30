class Solution {
    public boolean checkStrings(String s1, String s2) {
        var even= new HashMap<Character, Integer>();
        var odd= new HashMap<Character, Integer>();

        char[] ch= s2.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(i%2==0){
                even.put(ch[i] , even.getOrDefault(ch[i] ,0)+1);
            }else{
                odd.put(ch[i] , odd.getOrDefault(ch[i],0)+1);
            }
        }
        
        ch= s1.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(i%2==0){
                int temp= even.getOrDefault(ch[i] ,0);
                if(temp==0) return false;
                if(temp==1){
                    even.remove(ch[i]);
                    continue;
                }
                even.put(ch[i] ,even.get(ch[i])-1);
            }else{
                int temp=odd.getOrDefault(ch[i], 0);
                if(temp==0) return false;
                if(temp==1){
                    odd.remove(ch[i]);
                    continue;
                }
                odd.put(ch[i] , odd.get(ch[i])-1);
            }
        }
        if(even.size()==0 && odd.size()==0) return true;
        return false;
    }
}