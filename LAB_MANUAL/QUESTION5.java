class StackArray {

    int top;
    int size;
    int[] arr;

    // Constructor
    StackArray(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        arr[++top] = value;
        System.out.println(value + " pushed into stack");
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    // Peek operation
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    // Display stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QUESTION5 {

    public static void main(String[] args) {

        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        stack.display();

        stack.push(40);
        stack.push(50);
        stack.push(60);  // overflow test
    }
}
