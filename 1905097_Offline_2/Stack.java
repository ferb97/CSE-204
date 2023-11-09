public interface Stack<E> {

    public void clear();

    public void push(E it);

    public E pop();

    public int length();

    public E topValue();

    public void setDirection(int direction);

};
