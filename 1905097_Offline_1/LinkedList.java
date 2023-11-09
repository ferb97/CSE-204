class Link <E>{
    private E element;
    private Link<E> next;

    Link(E it, Link<E> nextval) {
        element = it;
        next = nextval;
    }

    Link(Link<E> nextval) {
        element = null;
        next = nextval;
    }

    public Link<E> next() {
        return next;
    }

    public Link<E> setNext(Link<E> nextval) {
        return next = nextval;
    }

    public E element() {
        return element;
    }

    public E setElement(E it) {
        return element = it;
    }

}


public class LinkedList<E> implements List<E>{
    private Link<E> head;
    private Link<E> tail;
    protected Link<E> curr;
    private int cnt;

    LinkedList(int size, E[] listArray) {
        curr = head = tail = new Link<E>(null);
        for(int i = 0; i < size; i++){
            append(listArray[i]);
        }
        cnt = size;
    }

    LinkedList() {
        curr = tail = head = new Link<E>(null);
        cnt = 0;
    }

    @Override
    public void clear() {
        head.setNext(null);
        curr = tail = head = new Link<E>(null);
        cnt = 0;
    }

    @Override
    public void insert(E it) {
        curr.setNext(new Link<E>(it, curr.next()));
        cnt++;
    }

    @Override
    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
        if(cnt == 1)
           curr = head;
    }

    @Override
    public E remove() {
        if (curr.next() == null)
            return null;
        E it = curr.next().element();
        if (tail == curr.next()) {
            tail = curr;
            tail.setNext(null);
            Link<E> it1 = head;
            while(it1.next() != curr){
                it1 = it1.next();
            }
            curr = it1;
            curr.setNext(tail);
        }
        else
            curr.setNext(curr.next().next());
        cnt--;
        return it;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        while(curr.next() != tail){
            curr = curr.next();
        }
    }

    @Override
    public void prev() {
        if (curr == head)
            return;
        Link<E> temp = head;
        while (temp.next() != curr)
            temp = temp.next();
        curr = temp;
    }

    @Override
    public void next() {
        if (curr == tail || curr.next() == tail)
            return;
        curr = curr.next();
    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=cnt) : "Position out of range";
        curr = head;
        for(int i=0; i<pos; i++)
            curr = curr.next();
    }

    @Override
    public E getValue() {
        if(curr.next() == null)
            return null;
        return curr.next().element();
    }

    @Override
    public int Search(E it){
        Link<E> temp = head;
        int pos = -1;
        for(int i = 0; temp.next() != null; i++){
            if(temp.next().element() == it){
               pos = i;
               break;
            }
            temp = temp.next();
        }
        return pos;
    }

}
