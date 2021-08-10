import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    public int size;

    public void addFirst(int value){
        Node newNode = new Node(value);

        if(isEmpty())
            first = last = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(int value){
        Node newNode = new Node(value);

        if(isEmpty())
            first = last = newNode;
        else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        Node current= first;

        while (current != null){
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last){
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
    }
    private boolean isEmpty(){
        return first == null;
    }
}
