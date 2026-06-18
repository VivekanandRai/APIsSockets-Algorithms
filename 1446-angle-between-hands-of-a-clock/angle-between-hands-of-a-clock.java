class Solution {
    public double angleClock(int hour, int minutes) {
        //1 min=6degree minhand in minute needle with rigid

        //1 hour = 30 degree minhand in hours needle
        // 1 minutes====>(0.5 degree minhand in hours needle)

        double minhand= minutes*6;

        double hourhand= hour*30 + 0.5*minutes;

        double difference = Math.abs(minhand-hourhand);

        return Math.min(difference , 360-difference);
    }
}