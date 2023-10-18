
import java.util.Arrays;

public class MyList<E>  {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;



    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];

    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of the bound");
        }
    }

    public void add(int index, E element) {
        ensureCapacity(DEFAULT_CAPACITY);
        checkIndex(index);
        for ( int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);
        E temp = elements[index];
        size--;
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        return temp;

    }

    public int size() {
        return size;
    }

//    public E clone() {}

    public boolean contains (E o) {
        return (indexOf(o) != -1);
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        ensureCapacity(DEFAULT_CAPACITY);
        elements[size] = o;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (elements.length < minCapacity) elements = Arrays.copyOf(elements, minCapacity);
        if (elements.length <= size) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public E get(int i) {
        checkIndex(i);
        return elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void printList() {
        StringBuilder result = new StringBuilder();

        result.append("[");
        if (size == 0) result = null;
        else {
            for (int i = 0; i < size; i++) {
                if (i == size - 1) result.append(elements[i]).append("]");
                else result.append(elements[i]).append(",");
            }
        }
        System.out.println(result);
    }


}
