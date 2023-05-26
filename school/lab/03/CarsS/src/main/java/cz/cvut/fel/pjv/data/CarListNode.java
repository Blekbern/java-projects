package cz.cvut.fel.pjv.data;

import cz.cvut.fel.pjv.model.Car;

public class CarListNode {
    CarListNode next;
    Car car;

    public CarListNode( CarListNode next, Car car ) {
        this.next = next;
        this.car = car;
    }
}
