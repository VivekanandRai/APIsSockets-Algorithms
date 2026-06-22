class Solution {
    int offset=10000;
    public int removeDuplicates(int[] nums) {
        int lastind=0;

        int n=nums.length;
        int[] freqm= new int[10000000];

        for(int i=0;i<n;i++){
            if(freqm[ nums[i] + offset ] ==2 ) {
                nums[i]=Integer.MAX_VALUE;
            }else{
                freqm[ nums[i] + offset ]++;
                nums[lastind]=nums[i];
                lastind++;
            }
        }
        return lastind;
    }
}