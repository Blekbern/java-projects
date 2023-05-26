package pjv.hodina10;

import java.util.ArrayList;

public class MyStack implements Stack {

    private final int SIZE = 10;

    private String[] words = new String[SIZE];
    private int cnt = 0;


    @Override
    public void add(String word) {
        if( isFull() ) {

        }
    }

    @Override
    public String pop() throws InterruptedException {
        if( isEmpty() ) {

        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }
}
