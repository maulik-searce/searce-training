import java.util.Collection;
import java.util.Scanner;

class LinkedList<E> {

    Node<E> head = null, tail = null;
    int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E e) {
            item = e;
            next = null;
        }

        Node(E e, Node<E> nextNode) {
            this.item = e;
            this.next = nextNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            try {
                sb.append("{ ListItem:  ");
                sb.append(this.item);
                // sb.append("\t");
                sb.append(", NextListItem : ");
                sb.append(this.next.item);
                sb.append("}");
            } catch (Exception e) {
                sb.append(e.getMessage());
            }
            return sb.toString();
        }
    }

    /**
     * Links e as first element
     * 
     * @param e
     */
    void linkFirst(E e) {
        final Node<E> newNode = new Node<>(e, head);
        head = newNode;
        size++;
    }

    /**
     * Links e as last element
     * 
     * @param e
     */
    void linkLast(E e) {

        final Node<E> oldTail = tail;
        final Node<E> newNode = new Node<>(e);

        this.tail = newNode;
        if (oldTail == null) {
            this.head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    boolean add(E e) {
        System.out.println("[INFO] : Inserting " + e + " at the end");
        linkLast(e);
        return true;
    }

    public void addFirst(E e) {
        System.out.println("[INFO] : Inserting " + e + " at the first");
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public E removeFirst() {
        final E headElem = head.item;
        head = head.next;
        size--;
        return headElem;
    }

    public String printLinkedList(Node<E> head) {
        StringBuilder sb = new StringBuilder();
        sb.append("LIST(" + size + ") -- [");

        Node<E> current = head;
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null)
                sb.append(" > ");
        }
        sb.append("]");
        return sb.toString();
    }

    public String printLinkedList() {
        return this.printLinkedList(this.head);
    }

    @Override
    public String toString() {
        return this.printLinkedList();
    }

}

public class LinkedListApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(7);
        list.addFirst(10);
        list.removeFirst();
        System.out.println(list);

        sc.close();
    }
}
