import java.lang.reflect.Array;

class Vector<E> {
    private Object[] elementData;
    private int size, capacity;

    Vector() {
        //random number 10
        this.capacity = 10;
        this.elementData = new Object[capacity];
    }

    Vector(int cap) {
        this.capacity = cap;
        this.elementData = new Object[this.capacity];
    }

    public void addElement(E elem) {

    }
}

public class VectorApp {
    public static void main(String[] args) {
        System.out.println("VectorApp.java");
    }
}
