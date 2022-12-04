public class LinkedQueue<E> {

    private DoublyLinkedNode<E> head;
    private DoublyLinkedNode<E> tail;

    int size;

    public void enqueue(E item) {

        DoublyLinkedNode<E> oldTail = this.tail;

        DoublyLinkedNode<E> newTailnode = new DoublyLinkedNode<E>(item);

        if(oldTail != null){
            oldTail.setNextNode(newTailnode);
            newTailnode.setNextNode(null);
            this.tail = newTailnode;

        }else{
            this.tail = newTailnode;
            this.head = newTailnode;
        }
        size++;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    public int length(){
        return size;
    }

    public E deque() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        E data = this.head.getData();

        this.head = this.head.getNextNode();

        size--;

        return data;
    }

    public E peek() {
        return this.head.getData();
    }

    public static void main(String[] args) {
        LinkedQueue<Double> queuelist = new LinkedQueue<Double>();
        queuelist.enqueue(60.0);
        queuelist.enqueue(12.0);
        queuelist.enqueue(16.4);
        queuelist.enqueue(26.5);

        queuelist.deque();
        System.out.println("queuelist.peek:"+ queuelist.peek());

        queuelist.deque();
        System.out.println("queuelist.length:"+queuelist.length());
        System.out.println("queuelist.peek:"+ queuelist.peek());
    }
}

public class DoublyLinkedNode<E> {
    private E data;
    private DoublyLinkedNode<E> nextNode;
    private DoublyLinkedNode<E> previousNode;

    public DoublyLinkedNode(E data) {
        this.data = data;
    }
    public E getData() {
        return data;
    }
    public DoublyLinkedNode<E> getNextNode() {
        return nextNode;
    }
    public void setNextNode(DoublyLinkedNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode<E> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedNode<E> prevNode) {
        this.previousNode = prevNode;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}