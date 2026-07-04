package SinglyLinkedList;

public class SinglyLinkedList<E> {

    // Member `Node<E>`
    private class Node<E> {

        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        E getElement() {
            return element;
        }

        void setElement(E element) {
            this.element = element;
        }

        Node<E> getNext() {
            return next;
        }

        void setNext(Node<E> node) {
            this.next = node;
        }
    }

    // Member `head`
    private Node<E> head = null;

    // Member `tail`
    private Node<E> tail = null;

    // Member `size`
    private int size = 0;

    // Constructor
    public SinglyLinkedList() {

    }

    // isEmpty
    public boolean isEmpty() {

        return size == 0;
    }

    // getFirst
    public E getFirst() {
        if (size != 0) {
            return head.getElement();
        }
        return null;
    }

    // getLast
    public E getLast() {
        if (size != 0) {
            return tail.getElement();
        }
        return null;
    }

    // addFirst
    public void addFirst(E element) {
        Node<E> newNode;
        if (size == 0) {
            newNode = new Node<E>(element, null);
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            newNode = new Node<E>(element, head);
            tail = newNode;
            size++;
        }
    }

    // addLast
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
            size++;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    // removeFirst
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return e;
    }
}
