class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        /*var a= new HashSet<Integer>();
        var b= new HashSet<Integer>();

        int l= A.length;
        int[] c= new int[l];

        HashSet<Integer> set;

        for(int i=0;i<l;i++){
            a.add(A[i]);
            b.add(B[i]);

            set= new HashSet<>(a);
            set.retainAll(b);
            c[i]=set.size();
        }

        return c;
        */
        int l= A.length;
        int[] c= new int[l];
        int[] freq= new int[l+1];

        int common=0;
        for(int i=0;i<l;i++){
            int a= A[i];int b=B[i];
            freq[a]++;
            if(freq[a]==2) common++;

            freq[b]++;
            if(freq[b]==2) common++;

            c[i]=common;
        }
        return c;
    }
}