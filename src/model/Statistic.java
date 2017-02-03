package model;

/**
 * Created by user on 03.02.2017.
 */
public class Statistic {
    long averageTime;
    double reached;

    public Statistic(long averageTime, double reached) {
        this.averageTime = averageTime;
        this.reached = reached;
    }

    public long getAverageTime() {
        return averageTime;
    }

    public double getReched() {
        return reached;
    }
}
