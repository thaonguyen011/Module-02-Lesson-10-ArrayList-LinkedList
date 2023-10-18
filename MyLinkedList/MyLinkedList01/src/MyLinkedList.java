public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;


    public MyLinkedList() {}

    private static class Node {
        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
        }

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("index " + index + " out of the bound");
        }
    }

    private Node accessNode(int index) {
        Node temp = head;
        if (index == 0) return head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void add(int index, E element) {
        checkIndex(index);
        if (numNodes == 0) addFirst(element);
        else if ( index == numNodes - 1) addLast(element);
        else {
            Node temp = accessNode(index - 1);
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        if (numNodes == 0) addFirst(e);
        else {
            Node temp = accessNode(numNodes - 1);
            temp.next = new Node(e);
            numNodes++;
        }

    }

    public E remove(int index) {
        checkIndex(index);
        Node temp;
        Node result;
        if (numNodes != 0) {
            if (index == 0) {
                result = head;
                head = head.next;
                return (E)result.data;
            } else if (index == 1) {
                return removeFirst();
            } else {
                temp = accessNode(index -1);
                result = temp.next;
                temp.next = temp.next.next;
            }
            numNodes--;
            return (E)result.data;
        } else return null;

    }

    public boolean remove(Object e) {
        int indexOfE = indexOf((E) e);
        if (indexOfE == -1) return false;
        else {
             remove(e);
             return true;
        }
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        Node temp = head;
        head = head.next;
        numNodes--;
        return (E)temp.data;
    }

    public E removeLast() {
        if (numNodes == 0) return null;
        else return remove(numNodes - 1);
    }

    public int size() {
        return numNodes;
    }

    public E[] clone() {
        E[] result = (E[]) new Object[numNodes];
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            result[i] = (E)temp.data;
            temp = temp.next;
        }
        return result;
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; temp != null; i++) {
            if (temp.data.equals(o)) return i;
            temp = temp.next;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public E get(int index) {
        checkIndex(index);
        return (E)accessNode(index).data;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(numNodes - 1);
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void printList() {
        System.out.print("List: ");
        Node temp = head;
        if (numNodes == 0) System.out.println((String) null);
        while (temp != null) {
                System.out.print(temp.data + "\t");
                temp = temp.next;
        }
    }
}
