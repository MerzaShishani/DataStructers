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
        if (isEmpty()) return;

        Node previous = first;
        Node current = first.next;
        while(current != null){
            Node next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        last = first;
        last.next=null;
        first = previous;
    }

    public int getKthFromTheEnd(int k){
        if(isEmpty()) throw new IllegalStateException();
        Node kth = first;
        Node second = first;

        for (int i = 1; i < k; i++) {
            second = second.next;
            if (second == null) throw new IllegalArgumentException();
        }
        while(second!=last){
            kth=kth.next;
            second=second.next;
        }
        return kth.value;
    }

    public void printMiddle(){
        if (isEmpty()) throw new IllegalStateException();
        Node a=first;
        Node b=first;
        while (b.next != last && b.next !=null){
            a=a.next;
            b=b.next.next;
        }

        if(b==last)
            System.out.println(a.value);
        else
            System.out.println(a.value+ " " +a.next.value);
    }

    private boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }
}
