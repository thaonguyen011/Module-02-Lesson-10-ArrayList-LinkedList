public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.add(2);
        list.addLast(3);
        list.add(1, 1);
        list.printList();
        System.out.println();



        list.clear();
        list.printList();

        list.add(1);
        list.printList();
    }
}
