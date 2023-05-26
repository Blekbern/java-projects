package cz.cvut.fel.pjv.data;

import cz.cvut.fel.pjv.model.Car;

public class CarLinkedList {
    private CarListNode head;
    private int count;

    public CarLinkedList() {
        head = null;
        count = 0;
    }
    public void add( Car car ) {
        head = new CarListNode( head, car );
        count++;
    }
}
