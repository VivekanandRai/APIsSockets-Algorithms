class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        long bigmass=mass;

        for(int i=0;i<asteroids.length ;i++){

            if(asteroids[i]<=bigmass) bigmass+=asteroids[i];
            else return false;
        }
        return true;
    }
}