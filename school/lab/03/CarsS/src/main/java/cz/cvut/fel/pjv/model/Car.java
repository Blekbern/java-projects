package cz.cvut.fel.pjv.model;

public class Car {

    private static int numberOfExistingCars = 0;
    private String manufacturer;
    private String modelName;
    private int year;
    private int speed;

    public Car(String manufacturer, String modelName, int year) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.year = year;
        Car.numberOfExistingCars++;
    }

    public static int getNumberOfExistingCars() {
        return numberOfExistingCars;
    }
}
