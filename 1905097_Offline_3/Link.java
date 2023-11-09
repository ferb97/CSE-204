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