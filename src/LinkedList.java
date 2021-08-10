import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        public int value;
        public Node next;
        private int size=0;

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
        if (first == last)
            first = last = null;
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else {
            Node previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node){
        Node current = first;
        while (current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int[] toArray(){
        int[] arr= new int[size];
        Node current=first;
        int index=0;
        while (current != null){
            arr[index++]=current.value;
            current=current.next;
        }
        return arr;
    }

    public void reverse(){
        int index=0;
        Node current=getPrevious(last);
        for (int i = 0; i < size; i++) {

        }
    }

    private boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }
}
