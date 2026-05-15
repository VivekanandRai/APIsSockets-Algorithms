class Solution {
    public int findMin(int[] nums) {
        int len= nums.length;
        
        if(len>=3 && nums[0]<nums[len/2] && nums[len/2]<nums[len-1]) return nums[0];//edge case

        int l=0;
        int r=len-1;
        while(l<r){

            if(r-l+1==2){
                return nums[l]<nums[r] ? nums[l]:nums[r];
            }
            int m= l+(r-l)/2;
            if(nums[m]<nums[0]){
                r=m;
                continue;
            }else if(nums[m]>nums[r]){
                l=m;
                continue;
            }

            return nums[m];
        }
        return nums[l];
        /*if(r==l) return nums[r];
        return nums[l];*/
    }
}