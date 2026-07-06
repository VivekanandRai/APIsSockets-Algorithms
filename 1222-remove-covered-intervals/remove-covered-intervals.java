class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;

        int count=0;
        Arrays.sort(intervals , (a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);

        int l=-1;
        int r=-1;

        for(int  i=0;i<len;i++){
            int[] curr= intervals[i];

            if(r >= curr[1]){
                count++;
            }
            r=Math.max(r , curr[1]);
        }
        return len- count;
    }
}