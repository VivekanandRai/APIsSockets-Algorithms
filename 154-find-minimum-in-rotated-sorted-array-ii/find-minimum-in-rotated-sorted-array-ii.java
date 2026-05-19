class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;

        int l=0;
        int r=len-1;

        while(l<r){
            int m =l+(r-l)/2;

            if(r-l+1==2) return nums[l]<nums[r] ? nums[l]:nums[r];

            if(nums[m]>nums[r]){//left sorted+ryt unsorted
                l=m+1;
                continue;
            }else if(nums[m]==nums[r] && nums[l]==nums[m]){
                l++;
                r--;
            }else{//right sorted+left unsorted
                r=m;
                continue;
            }
        }

        return nums[l];
    }
}