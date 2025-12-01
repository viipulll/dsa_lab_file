class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {

    Node head;

    // Insert at head
    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Delete by value
    public void deleteByValue(int value) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case: deleting head
        if (head.data == value) {
            Node temp = head;

            // if only one node
            if (head.next == head) {
                head = null;
                return;
            }

            // find last node
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = head.next;
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next.data == value) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found.");
        }
    }

    // Traverse
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Circular List: ");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}

public class Question3 {

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.insertAtHead(20);
        list.insertAtHead(10);

        list.insertAtTail(30);
        list.insertAtTail(40);

        list.traverse();

        System.out.println("Deleting value 30...");
        list.deleteByValue(30);

        list.traverse();
    }
}
