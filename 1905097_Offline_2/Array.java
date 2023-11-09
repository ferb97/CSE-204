public class Array<E> implements Stack<E> {

    private static final int defaultSize = 10;
    private int maxSize;
    private int top;
    private E[] listArray;
    private int direction;

    Array() {
        this(defaultSize, 1);
    }

    Array(int size, int direction) {
        this.direction = direction;
        maxSize = size;
        if(direction == 1){
           top = 0;
        }
        else{
            top = maxSize;
        }
        listArray = (E[])new Object[size];
    }

    Array(E[] array, int direction) {
        this.listArray = array;
        this.direction = direction;
        this.maxSize = listArray.length;
        if(direction == 1){
            top = 0;
        }
        else{
            top = maxSize;
        }
    }

    public void clear(){
        if(direction == 1){
            top = 0;
        }
        else{
            top = maxSize;
        }
    }

    public void push(E it){
        if(top == maxSize && direction == 1) {
            this.maxSize = this.maxSize * 2;
            E[] temp = (E[]) new Object[maxSize];
            for (int i = 0; i < top; i++) {
                temp[i] = listArray[i];
            }
            temp[top++] = it;
            listArray = (E[]) new Object[maxSize];
            listArray = temp;
        }
        else if(top == 0 && direction == -1){
            this.maxSize = this.maxSize * 2;
            E[] temp = (E[]) new Object[maxSize];
            for(int i = maxSize - 1; i >= maxSize/2; i--){
                temp[i] = listArray[i - maxSize/2];
            }
            top = maxSize/2;
            temp[--top] = it;
            listArray = (E[]) new Object[maxSize];
            listArray = temp;
        }
        else{
            if(direction == 1){
                listArray[top++] = it;
            }
            else{
                listArray[--top] = it;
            }
        }
    }

    public E pop(){
        assert (top != 0 && direction == 1) || (top != maxSize && direction == -1) : "Stack is empty";
        if(direction == 1){
            return listArray[--top];
        }
        else{
            return listArray[top++];
        }
    }

    public int length(){
        if(direction == 1){
            return top;
        }
        else{
            return maxSize - top;
        }

    }

    public E topValue(){
        if((top <= 0 && direction == 1) || (top >= maxSize && direction == -1))
            return null;
        if(direction == 1){
            return listArray[top - 1];
        }
        else{
            return listArray[top];
        }

    }

    public void setDirection(int direction){
        if(this.direction == -1 && direction == 1){
           top = 0;
        }
        else if(this.direction == 1 && direction == -1){
            top = maxSize;
        }
        this.direction = direction;
    }

}
