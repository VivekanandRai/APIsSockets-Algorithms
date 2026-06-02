class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n=landStartTime.length;

        int m=waterStartTime.length;

        int[][] land= new int[n][2];

        int[][] water= new int[m][2];



        for(int i=0;i<n;i++){

            land[i][0]=landStartTime[i];

            land[i][1]=landDuration[i]+landStartTime[i];//earliest it can finish

        }



        for(int i=0;i<m;i++){

            water[i][0]=waterStartTime[i];

            water[i][1]=waterDuration[i]+waterStartTime[i];//earliest it can finish

        }



        Arrays.sort(land,(a,b)->a[1]-b[1]);

        Arrays.sort(water,(a,b)->a[1]-b[1]);



        int lw=100000;

        int wl=100000;



        int start=land[0][1];

        for(int i=0;i<m;i++){

            //land chosen then water

            if(water[i][0]>=land[0][1]){

                lw=Math.min(lw, water[i][1]);

            }else{

                lw=Math.min(lw, start+water[i][1]-water[i][0]);

            }

        }



        int start2=water[0][1];

        for(int i=0;i<n;i++){

            if(land[i][0]>=water[0][1]){

                wl=Math.min(wl, land[i][1]);

            }else{

                wl=Math.min(wl, start2+land[i][1]-land[i][0]);

            }

        }

        return Math.min(wl ,lw);

        

        

        

    }

}