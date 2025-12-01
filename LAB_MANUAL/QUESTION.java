public class QUESTION1 {

    // Traverse the array
    public static void traverse(int[] arr, int n) {
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Insert element at a given position
    public static int insertAtPos(int[] arr, int n, int pos, int value) {
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = value;
        n++;
        return n;
    }

    // Delete element at a given position
    public static int deleteAtPos(int[] arr, int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
        return n;
    }

    public static void main(String[] args) {

        int[] arr = new int[100];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        int n = 5;

        // Traverse
        traverse(arr, n);

        // Insert 99 at position 2
        n = insertAtPos(arr, n, 2, 99);
        traverse(arr, n);

        // Delete element at position 3
        n = deleteAtPos(arr, n, 3);
        traverse(arr, n);
    }
}
