package cz.cvut.fel.pjv;

/**
 * @author Jirka Sebek
 */
public class Start {

    public static void main(String[] args) {

         
        /* homework */
        Queue queue = new CircularArrayQueue(10);

//        System.out.println( queue.dequeue() );
//        queue.enqueue("Starkiller");
//        System.out.println( queue.isFull() );
//        System.out.println( queue.isEmpty() );
        queue.printAllElements();
//        System.out.println( queue.size() );
        queue.enqueue("C-3PO");
        queue.enqueue("Jabba the Hutt");
        queue.enqueue("HK-47");
        queue.enqueue("Darth Nihilus");
        queue.enqueue("Count Dooku1");
        queue.enqueue("Count Dooku2");
        queue.enqueue("Count Dooku3");
        queue.enqueue("Count Dooku4");
        queue.enqueue("Count Dooku5");
        queue.enqueue("Count Dooku6");
        queue.enqueue("Count Dooku7");
        queue.enqueue("Count Dooku8");
//        System.out.println("size: " + queue.size());
//        System.out.println("Value dequeued from CircularArrayQueue: " + queue.dequeue());
//        System.out.println("printing all elements: ");
        queue.printAllElements();
        System.out.println( queue.size() );
        queue.dequeue();
        queue.printAllElements();
        System.out.println( queue.size() );
        queue.enqueue("Jango Fett");
        queue.printAllElements();
//        System.out.println("size: " + queue.size());
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
    }
}
