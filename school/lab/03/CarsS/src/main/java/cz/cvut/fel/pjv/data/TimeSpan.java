package cz.cvut.fel.pjv.data;

public class TimeSpan {
    private int hour;
    private int minute;
    private int second;

    public TimeSpan() {

    }

    public TimeSpan(int second) {
        setTime( second / 3600, second / 60, second%60 );
    }

    public TimeSpan(int minute, int second) {
        setTime( minute/60, minute%60, second );
    }

    public TimeSpan(int hour, int minute, int second) {
        setTime( hour, minute, second );
    }

    public void setTime( int hour, int minute, int second ) {
        if( hour >= 0 ) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
        if( minute >= 0 && minute <= 59 ) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
        if( second >= 0 && second <= 59 ) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public TimeSpan add( int second ) {
        return this;
    }

    public int getTotalSeconds() {
        return hour*3600 + minute*60 + second;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
