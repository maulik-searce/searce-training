
import java.util.Scanner;

/**
 * @author Maulik Pipaliya
 */

class LinkedList<E> {
    Node<E> head, tail;
    int size;

    /**
     * Static class for creating a node
     */

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            item = element;
            next = null;
        }
    }

    /**
     * Function to add an element to the list - in the end
     * 
     * @param itemToAdd
     */
    public void add(E itemToAdd) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(itemToAdd);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * Recursive function to print the list
     * 
     * @param head
     */
    public void printList(Node<E> head) {
        if (head == null) {
            return;
        }
        System.out.println(head.item + " ");
        printList(head.next);
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

}

public class Q2_LinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.printList();
        sc.close();

    }
}
