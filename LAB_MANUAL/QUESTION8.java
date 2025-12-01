class CircularQueue {

    int front, rear, size;
    int[] arr;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if queue is full
    boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1 == front);
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        if (front == -1) { // first element
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = value;
        System.out.println(value + " enqueued");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        int data = arr[front];

        if (front == rear) { // last element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return data;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Circular Queue: ");
        int i = front;

        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }

        System.out.println();
    }
}

public class QUESTION8 {

    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);

        cq.display();

        System.out.println("Dequeued: " + cq.dequeue());
        cq.display();

        cq.enqueue(40);
        cq.enqueue(50);
        cq.enqueue(60);  // wrap around
        cq.display();

        cq.enqueue(70);  // Overflow
    }
}
