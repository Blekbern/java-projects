package org.example;

public class AnyHolder<T> { // AnyHolder<T extends Bicycle>
    private T bike;

    public AnyHolder( T bike ) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return "Anyholder: " + bike;
    }
}
