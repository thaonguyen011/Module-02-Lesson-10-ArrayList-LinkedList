import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    public MyList() {}

    private void checkIndex(int index) {
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("index " + index + " out of bounds");
       }
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
           int newSize = elements.length * 2;
           elements = Arrays.copyOf(elements, newSize);
        }
    }

    public void add(E e) {
      ensureCapacity();
      elements[size++] = e;
    }

    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public void printList() {
        for (E element : elements) {
            if(element!=null) System.out.println(element);
        }
    }
}
