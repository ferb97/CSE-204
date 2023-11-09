public class LinkedList<E> implements Queue<E>{

    private Link<E> front;
    private Link<E> rear;
    private int size;

    public LinkedList() {
        init();
    }
    public LinkedList(int size) {
        init();
    }

    private void init() {
        front = rear = new Link<E>(null);
        size = 0;
    }

    @Override
    public void clear() {
        init();
    }

    @Override
    public void enqueue(E it) {
        rear.setNext(new Link<E>(it, null));
        rear = rear.next();
        size++;
    }

    @Override
    public E dequeue() {
        assert size != 0 : "Queue is empty";
        E it = front.next().element();
        front.setNext(front.next().next());
        if (front.next() == null)
            rear = front;
        size--;
        return it;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E frontValue() {
        if(size ==  0)
            return null;
        return front.next().element();
    }

    @Override
    public E rearValue() {
        if(size ==  0)
            return null;
        return rear.element();
    }

    @Override
    public E leaveQueue() {
        assert size != 0 : "Queue is empty";
        E it = rear.element();
        Link<E> temp = front;
        while(temp.next() !=rear){
            temp = temp.next();
        }
        rear = temp;
        rear.setNext(null);
        size--;
        return it;
    }
}
