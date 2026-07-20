package DoublyCircularlyLinkedList;

public class DoublyCircularlyLinkedList<E> {

    // ---------------- Nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // ---------------- Instance variables ----------------
    private Node<E> tail = null;
    private int size = 0;

    // ---------------- Constructor ----------------
    public DoublyCircularlyLinkedList() {
    }

    // ---------------- Access methods ----------------

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // ---------------- Update methods ----------------

    // Rotate the list one step forward
    public void rotateForward() {
        if (tail != null)
            tail = tail.getNext();
    }

    // Rotate the list one step backward
    public void rotateBackward() {
        if (tail != null)
            tail = tail.getPrev();
    }

    // Insert at the beginning
    public void addFirst(E e) {
        if (isEmpty()) {
            Node<E> newest = new Node<>(e, null, null);
            newest.setNext(newest);
            newest.setPrev(newest);
            tail = newest;
        } else {
            Node<E> head = tail.getNext();
            Node<E> newest = new Node<>(e, tail, head);

            head.setPrev(newest);
            tail.setNext(newest);
        }
        size++;
    }

    // Insert at the end
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    // Remove the first node
    public E removeFirst() {
        if (isEmpty())
            return null;

        Node<E> head = tail.getNext();

        if (head == tail) {
            tail = null;
        } else {
            Node<E> newHead = head.getNext();
            tail.setNext(newHead);
            newHead.setPrev(tail);
        }

        size--;
        return head.getElement();
    }

    // Remove the last node
    public E removeLast() {
        if (isEmpty())
            return null;

        Node<E> oldTail = tail;

        if (tail.getNext() == tail) {
            tail = null;
        } else {
            Node<E> newTail = tail.getPrev();
            Node<E> head = tail.getNext();

            newTail.setNext(head);
            head.setPrev(newTail);

            tail = newTail;
        }

        size--;
        return oldTail.getElement();
    }

    // ---------------- Utility ----------------

    public void printForward() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        Node<E> current = tail.getNext();

        do {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        } while (current != tail.getNext());

        System.out.println();
    }

    public void printBackward() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        Node<E> current = tail;

        do {
            System.out.print(current.getElement() + " ");
            current = current.getPrev();
        } while (current != tail);

        System.out.println();
    }
}
