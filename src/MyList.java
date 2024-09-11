public class MyList<T> {
    private T[] arr;
    private int elementCount;
    private int capacity;
    private int index;
    private static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[]) new Object[capacity];
        elementCount = 0;
        index = 0;
    }

    public MyList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        elementCount = 0;
        index = 0;
    }

    public void add(T data) {

        if (this.getElementCount() == (this.getCapacity() - 1)) {
            setCapacity(getCapacity() * 2);
        }
        this.arr[index] = data;
        this.index++;
        this.elementCount++;

    }

    public T get(int index) {
        return this.arr[index];
    }

    public void remove(int removeIndex) {
        if (removeIndex > 0 && removeIndex < this.elementCount) {
            for (int i = removeIndex; i < getElementCount(); i++) {
                this.arr[i] = this.arr[i + 1];
                this.index--;
            }
        } else {
        }
    }

    public void set(int index, T data) {
        if (index < this.elementCount && index >= 0) {
            this.arr[index] = data;
        } else {
        }
    }

    public String toString() {
        String arrString = "";

        for (T i : this.arr) {
            if (i != null) {
                arrString += i + " ";
            }
        }
        return arrString;
    }

    public int size() {
        return getElementCount();
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == data){
                index = i;
                break;
            }
        }
        return index;
    }
    public int lastIndexOf(T data){
        int index = -1;
        for (int i = elementCount-1; i >= 0; i--){
            if (arr[i] == data){
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean isEmpty(){
        return elementCount==0;
    }
    public T[] toArray(){
        T[] tempArray = (T[]) new Object[elementCount];
        System.arraycopy(arr, 0, tempArray, 0, elementCount);
        return tempArray;
    }
    public void clear(){
        for (int i = 0 ;i<elementCount;i++){
            arr[i]= null;
        }
        elementCount=0;
    }
    public MyList<T> subList(int start, int finish){
        MyList<T> subList = new MyList<T>(finish-start);
        for (int i = start; i<finish;i++){
            subList.add(arr[i]);
        }
        return subList;
    }
    public boolean contains(T data){
        boolean isContains = false;
        for (int i =0; i<elementCount;i++){
            if (arr[i] == data){
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
//        System.arraycopy(this.arr, 0, newArray, 0, this.arr.length);
        for (int i = 0; i < this.arr.length; i++) {
            newArray[i] = this.arr[i];
        }
        this.arr = newArray;
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
