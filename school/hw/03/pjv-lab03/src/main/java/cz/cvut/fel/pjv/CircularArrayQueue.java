package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {

    public static final int MAX_SIZE = 5;
    private int capacity;
    private String ArrayQ[];
    private int qHead = 0;
    private int qTail = 0;
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        capacity = MAX_SIZE;
        ArrayQ = new String[capacity];
    }


    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue( int capacity ) {
        this.capacity = capacity;
        ArrayQ = new String[this.capacity];
    }

    @Override
    public int size() {
        int cnt = 0;
        if( isEmpty() )
            return 0;
        if( qTail > qHead ) {
            for( int i = qHead; i < qTail; i++ )
                cnt++;
        } else {
            // qTail <= qHead
            for( int i = qHead; i < ArrayQ.length; i++ )
                cnt++;
            for( int i = 0; i < qTail; i++ )
                cnt++;
        }
        return cnt;
    }

    @Override
    public boolean isEmpty() {
        for( int i = 0; i < ArrayQ.length; i++ ) {
            if( ArrayQ[i] != null )
                return false;
        }
        return true;
    }

    @Override
    public boolean isFull() {
        for( int i = 0; i < ArrayQ.length; i++ ) {
            if( ArrayQ[i] == null )
                return false;
        }
        return true;
    }


    @Override
    public boolean enqueue( String obj ) {
        if( isFull() ) { // checks whether the queue is full (cant add anymore)
            return false;
        } else {
            ArrayQ[qTail] = obj;
            qTail = incrementIndex( qTail );
        }
        return true;
    }

    @Override
    public String dequeue() {
        String res;
        if( isEmpty() ) {
            return null;
        } else {
            res = ArrayQ[qHead];
            ArrayQ[qHead] = null;
            qHead = incrementIndex( qHead );
        }
        return res;
    }

    @Override
    public void printAllElements() {
        if( isEmpty() )
            return;
        if( qTail > qHead ) {
            for( int i = qHead; i < qTail; i++ )
                System.out.println( ArrayQ[i] );
        } else {
            // qTail <= qHead
            for( int i = qHead; i < ArrayQ.length; i++ )
                System.out.println( ArrayQ[i] );
            for( int i = 0; i < qTail; i++ )
                System.out.println( ArrayQ[i] );
        }
    }

    /**
     * @param index holds the current position of pointer
     * @returns incremented index by 1 (% capacity makes sure to not overflow)
     */
    public int incrementIndex( int index ) {
        return (index + 1) % capacity;
    }
}
