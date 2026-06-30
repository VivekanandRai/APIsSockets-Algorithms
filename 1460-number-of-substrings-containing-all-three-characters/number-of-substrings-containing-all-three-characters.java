class Solution {
    public int numberOfSubstrings(String s) {
        char[] ch= s.toCharArray();

        int tot=0;

        int len= s.length();
        HashMap<Integer , Integer> hm = new HashMap<>();

        for( int l=0;l<len;l++){
            for(int r=l ;r<len ;r++){
                int index= ch[r]-'a';
                hm.put(index , hm.getOrDefault(index, 0)+1);

                while(hm.size()==3){
                    tot+= len -r;

                    if(hm.get(ch[l]-'a')==1) hm.remove(ch[l]-'a');
                    else hm.put(ch[l]-'a' , hm.get(ch[l]-'a')-1);

                    l++;
                }
            }
                
        }
        return tot;
    }
}