package edu.kis.vh.nursery.list;

public class IntLinkedList {

    private static class Node {

        private int value;
        private Node prev, next;

        //TODO zmiana nazwy zmiennej i (obecna nazwa nie mówi czym jest przekazywany parametr)
        public Node(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private static final int ERR_CODE = -1;
    private Node last;
    //TODO zmiana nazwy zmiennej i (obecna nazwa nie mówi czym jest zmienna)
    private int i;

    //TODO zmiana nazwy zmiennej i (obecna nazwa nie mówi czym jest przekazywany parametr)
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    //TODO usunąć metodę lub zmienić kod, tak aby zapełnienie listy było możliwe (obecnie jest niemożliwe, więc metoda jest niepotrzebna)
    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return ERR_CODE;
        return last.getValue();
    }

    public int pop() {
        if (isEmpty())
            return ERR_CODE;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }

}
