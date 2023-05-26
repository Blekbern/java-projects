package cz.cvut.fel.pjv;


public class TreeImpl implements Tree {

    private NodeImpl root = null;

    public TreeImpl() {}

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void setTree(int[] values) {
        if( values == null ) {
            return;
        }
        root = makeTree( values, 0, values.length, 0 );
    }

    @Override
    public String toString() {
        String res = printTree( "", root, 0 );
        return res;
    }

    /**
     *
     * @param res string to output
     * @param currNode to get the value of the current node
     * @param depth determines the count of white spaces
     * @return string res
     */
    public String printTree( String res, Node currNode, int depth ) {
        if( currNode == null )
            return res;
        for( int i = 0; i < depth; i++ )
            res += " ";
        res += "- " + currNode.getValue() + "\n";
        res = printTree( res, currNode.getLeft(), depth + 1 );
        res = printTree( res, currNode.getRight(), depth + 1 );
        return res;
    }

    /**
     *
     * @param values array holding integers
     * @param lb lower bound of an array
     * @param ub upper bound of an array
     * @param depth holds the current depth of the tree for spaces
     * @return the current node
     */
    public NodeImpl makeTree( int values[], int lb, int ub, int depth ) {
        if( lb == ub )
            return null;
        NodeImpl currNode = new NodeImpl( values[(ub + lb) / 2] );
        currNode.setNodeLeft( makeTree( values, lb, (ub + lb) / 2, depth + 1 ) );
        currNode.setNodeRight( makeTree( values, (ub + lb) / 2 + 1, ub, depth + 1) );
        return currNode;
    }

    public static void main( String[] args ) {
        TreeImpl tree = new TreeImpl();
//        int array[] = {};
//        int array1[] = {1};
//        int array2[] = {1, 2};
//        int array3[] = {1, 2, 3};
//        int array4[] = {1, 2, 3, 4};
//        int array5[] = {1, 2, 3, 4, 5};
        int array6[] = {1, 2, 3, 4, 5, 6};
//        int array7[] = {1, 2, 3, 4, 5 ,6, 7};
//        int array8[] = {1, 2, 3, 4, 5, 6, 7, 8};
//        int array9[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int array10[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int array11[] = null;
//        int array12[] = {1, 1, 1, 1};
//        int array13[] = {-1, 0, 0, 50, 20};
        tree.setTree( array6 );
        System.out.println( tree.toString() );
    }
}
