interface Queue<E> {

    public void clear();

    public void enqueue(E it);

    public E dequeue();

    public int length();

    public E frontValue();

    public E rearValue();

    public E leaveQueue();

}
