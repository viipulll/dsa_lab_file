class LinearQueue {

    int front, rear, size;
    int[] arr;

    LinearQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow!");
            return;
        }
        arr[++rear] = value;
        System.out.println(value + " enqueued");
    }

    // Dequeue operation
    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        return arr[front++];
    }

    // Peek operation
    public int peek() {
        if (front > rear) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Display operation
    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QUESTION7 {

    public static void main(String[] args) {

        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);  // Overflow
    }
}
