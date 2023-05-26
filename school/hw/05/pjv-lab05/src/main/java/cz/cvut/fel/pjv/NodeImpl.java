package cz.cvut.fel.pjv;

public class NodeImpl implements Node {

    private int value;
    private NodeImpl left;
    private NodeImpl right;

    public NodeImpl( int num ) {
        value = num;
        left = null;
        right = null;
    }

    public void setNodeLeft( NodeImpl node ) {
        left = node;
    }

    public void setNodeRight( NodeImpl node ) {
        right = node;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return value;
    }
}
