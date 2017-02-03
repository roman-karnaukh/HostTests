package model;

/**
 * Created by user on 03.02.2017.
 */
public class PingResult {
    long time;
    boolean result;

    public PingResult(long time, boolean result){
        this.time = time;
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public boolean getResult() {
        return result;
    }
}
