package cz.cvut.fel.pjv.data;

import cz.cvut.fel.pjv.model.Car;

import java.util.Objects;

public class RaceResult implements Comparable {
    private Car car;
    private TimeSpan time;

    public RaceResult(Car car, TimeSpan time) {
        this.car = car;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult that = (RaceResult) o;
        return Objects.equals(car, that.car) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, time);
    }

    @Override
    public int compareTo(Object o) {
        final TimeSpan other = (TimeSpan) o;
        return time.getTotalSeconds() - ((TimeSpan) o).getTotalSeconds();
    }

    public TimeSpan getTs() {
        return time;
    }

    public Car getCar() {
        return car;
    }
}
