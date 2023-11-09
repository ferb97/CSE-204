class BST<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E>{

    private BSTNode<Key, E> root;
    private int nodecount;

    BST() {
        root = null;
        nodecount = 0;
    }

    public BSTNode<Key, E> getRoot(){
        return root;
    }

    @Override
    public void clear() {
        root = null;
        nodecount = 0;
    }

    @Override
    public void insert(Key k, E e) {
        root = inserthelp(root, k, e);
        nodecount++;
    }

    @Override
    public E remove(Key k) {
        E temp = findhelp(root, k);
        if (temp != null) {
            root = removehelp(root, k);
            nodecount--;
        }
        return temp;
    }

    @Override
    public E removeAny() {
        if (root == null) return null;
        E temp = root.element();
        root = removehelp(root, root.key());
        nodecount--;
        return temp;
    }

    @Override
    public E find(Key k) {
        return findhelp(root, k);
    }

    @Override
    public int size() {
        return nodecount;
    }

    private BSTNode<Key,E> inserthelp(BSTNode<Key,E> rt, Key k, E e) {
        if (rt == null)
            return new BSTNode<Key,E>(k, e);
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(inserthelp(rt.left(), k, e));
        else
            rt.setRight(inserthelp(rt.right(), k, e));
        return rt;
    }

    private E findhelp(BSTNode<Key,E> rt, Key k) {
        if (rt == null)
            return null;
        if (rt.key().compareTo(k) > 0)
            return findhelp(rt.left(), k);
        else if (rt.key().compareTo(k) == 0)
            return rt.element();
        else
            return findhelp(rt.right(), k);
    }

    private BSTNode<Key,E> deletemin(BSTNode<Key,E> rt) {
        if (rt.left() == null) return rt.right();
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }

    private BSTNode<Key,E> getmin(BSTNode<Key,E> rt) {
        if (rt.left() == null) return rt;
        return getmin(rt.left());
    }

    private BSTNode<Key,E> removehelp(BSTNode<Key,E> rt,Key k) {
        if (rt == null)
            return null;
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(removehelp(rt.left(), k));
        else if (rt.key().compareTo(k) < 0)
            rt.setRight(removehelp(rt.right(), k));
        else {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
                return rt.left();
            else {
                BSTNode<Key,E> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setKey(temp.key());
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }

    private void printBinaryTreeHelper(BSTNode<Key, E> rt){
        if(rt.key() == null)
            return;
        System.out.print(rt.key());
        if(rt.left() == null && rt.right() == null) {
            return;
        }
        System.out.print("(");
        if(rt.left() != null)
            printBinaryTreeHelper(rt.left());
        System.out.print(")");
        System.out.print("(");
        if(rt.right() != null)
            printBinaryTreeHelper(rt.right());
        System.out.print(")");
    }

    public void printBinaryTree(){
        printBinaryTreeHelper(root);
    }

    private void printPreOrderHelper(BSTNode<Key, E> rt){
        if(rt == null)
            return;
        System.out.print(rt.key() + " ");
        printPreOrderHelper(rt.left());
        printPreOrderHelper(rt.right());
    }

    public void printPreOrder(){
        printPreOrderHelper(root);
    }

    private void printInOrderHelper(BSTNode<Key, E> rt){
        if(rt == null)
            return;
        printInOrderHelper(rt.left());
        System.out.print(rt.key() + " ");
        printInOrderHelper(rt.right());
    }

    public void printInOrder(){
        printInOrderHelper(root);
    }

    private void printPostOrderHelper(BSTNode<Key, E> rt){
        if(rt == null)
            return;
        printPostOrderHelper(rt.left());
        printPostOrderHelper(rt.right());
        System.out.print(rt.key() + " ");
    }

    public void printPostOrder(){
        printPostOrderHelper(root);
    }
}