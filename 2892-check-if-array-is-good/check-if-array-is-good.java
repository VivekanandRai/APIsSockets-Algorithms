class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        if(l==1) return false;
        if(nums[l-1] >= l) return false;
        int cap=l-1;

        int ind=1;
        for(int i :nums){
            if(ind !=i) break;
            ind++;
        }
        if(ind==cap+1) return true;
        return false;
    }
}