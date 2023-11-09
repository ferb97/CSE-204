public class Array<E> implements List<E> {
    private int maxSize;
    private int listSize;
    private int curr;
    private E[] listArray;
    private int chunkSize;

    Array(int chunkSize, E[] listArray, int listSize){
        this.chunkSize = chunkSize;
        this.maxSize = chunkSize;
        this.listArray = (E[]) new Object[this.maxSize];
        this.listSize = listSize;
        for(int i = 0; i < listArray.length; i++){
            this.listArray[i] = listArray[i];
        }
        this.curr = 0;
    }

    Array() {
        this(10);
    }

    Array(int size) {
        maxSize = chunkSize = size;
        listSize = curr = 0;
        listArray = (E[])new Object[size];
    }

    @Override
    public void clear(){
        this.listSize = 0;
        this.curr = 0;
        this.maxSize = 0;
    }

    @Override
    public void insert(E item){
        if(this.listSize == this.maxSize){
           this.maxSize = this.maxSize + this.chunkSize;
           E[] temp = (E[]) new Object[maxSize];
           for(int i = 0; i < listSize; i++){
               temp[i] = listArray[i];
           }
           for(int i = listSize; i > curr; i--) {
               temp[i] = temp[i - 1];
           }
           temp[curr] = item;
           listSize++;
           listArray = (E[]) new Object[maxSize];
           listArray = temp;
        }
        else{
            for(int i = listSize; i > curr; i--) {
                listArray[i] = listArray[i - 1];
            }
            listArray[curr] = item;
            listSize++;
        }
    }

    @Override
    public void append(E item){
        if(this.listSize == this.maxSize){
            this.maxSize = this.maxSize + this.chunkSize;
            E[] temp = (E[]) new Object[maxSize];
            for(int i = 0; i < listSize; i++){
                temp[i] = listArray[i];
            }
            temp[listSize++] = item;
            listArray = (E[]) new Object[maxSize];
            listArray = temp;
            if(listSize == 1)
                curr = 0;
        }
        else{
            listArray[listSize++] = item;
        }
    }

    @Override
    public E remove(){
        if ((curr < 0) || (curr >= listSize))
            return null;
        E item = listArray[curr];
        for(int i = curr; i < listSize-1; i++)
            listArray[i] = listArray[i+1];
        if(curr == listSize - 1)
            curr--;
        listSize--;
        return item;
    }

    @Override
    public void moveToStart() {
        curr = 0;
    }

    @Override
    public void moveToEnd() {
        curr = listSize-1;
    }

    @Override
    public void prev() {
        if (curr != 0)
            curr--;
    }

    @Override
    public void next() {
        if (curr < listSize-1)
            curr++;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        return curr;
    }

    @Override
    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos < listSize) : "Position out of range";
        curr = pos;
    }

    @Override
    public E getValue() {
        if(curr < 0 || curr >= listSize)
           return null;
        return listArray[curr];
    }

    @Override
    public int Search(E item){
        int pos = -1;
        for(int i = 0; i < listSize; i++){
            if(listArray[i] == item){
               pos = i;
               break;
            }
        }
        return pos;
    }

}
