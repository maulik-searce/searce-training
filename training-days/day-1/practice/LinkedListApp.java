import java.util.Scanner;

class LinkedList<E> {

    Node<E> head = null, tail = null;
    int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            item = element;
            next = null;
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

    public void add(E elem) {
        final Node<E> oldTail = tail;
        final Node<E> newNode = new Node<>(elem);

        this.tail = newNode;
        if (oldTail == null) {
            this.head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[INFO]: LIST(" + size + ") NOW - [");

        Node<E> current = head;
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null)
                sb.append("->");
        }
        sb.append("]");

        return sb.toString();
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

        System.out.println(list);

        sc.close();
    }
}
