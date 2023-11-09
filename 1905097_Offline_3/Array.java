public class Array<E> implements Queue<E> {

    private static final int defaultSize = 10;
    private int maxSize;
    private int front;
    private int rear;
    private E[] listArray;

    Array(){
        this(defaultSize);
    }

    Array(int size){
        maxSize = size + 1;
        rear = 0;
        front = 1;
        listArray = (E[])new Object[maxSize];
    }

    Array(E[] array){
        maxSize = array.length;
        rear = 0;
        front = 1;
        listArray = array;
    }

    @Override
    public void clear() {
        rear = 0;
        front = 1;
    }

    @Override
    public void enqueue(E it) {
        if((rear + 2) % maxSize == front){
            E[] temp = (E[]) new Object[2 * maxSize - 1];
            for(int i = 1; i < maxSize; i++){
                temp[i] = listArray[(front + i - 1) % maxSize];
            }
            front = 1;
            rear = maxSize - 1;
            maxSize = maxSize * 2 - 1;
            listArray = (E[]) new Object[maxSize];
            listArray = temp;
        }
        rear = (rear + 1) % maxSize;
        listArray[rear] = it;
    }

    @Override
    public E dequeue() {
        assert length() != 0 : "Queue is empty";
        E it = listArray[front];
        front = (front + 1) % maxSize;
        return it;
    }

    @Override
    public int length() {
        return (rear + maxSize + 1 - front) % maxSize;
    }

    @Override
    public E frontValue() {
        if(length() == 0)
          return null;
        return listArray[front];
    }

    @Override
    public E rearValue() {
        if(length() == 0)
            return null;
        return listArray[rear];
    }

    @Override
    public E leaveQueue() {
        assert length() != 0 : "Queue is empty";
        E it = listArray[rear];
        rear = (rear - 1 + maxSize) % maxSize;
        return it;
    }
}
