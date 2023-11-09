class LinkedList<E> implements Stack<E> {
    private Link<E> top;
    private int size;

    public LinkedList() {
        top = null;
        size = 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E it) {
        top = new Link<E>(it, top);
        size++;
    }

    @Override
    public E pop() {
        assert top != null : "Stack is empty";
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E topValue() {
        if(size == 0)
           return null;
        return top.element();
    }

    @Override
    public void setDirection(int direction) {

    }

}