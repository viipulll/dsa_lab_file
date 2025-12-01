public class Question9 {

    // Iterative linear search: returns index or -1
    public static int linearSearchIterative(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 9, 1};
        int key = 4;

        int idx = linearSearchIterative(arr, key);
        if (idx != -1) {
            System.out.println("Element " + key + " found at index: " + idx);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }

        // test not-found case
        key = 7;
        idx = linearSearchIterative(arr, key);
        System.out.println("Searching for " + key + ": " + (idx == -1 ? "Not found" : "Found at index " + idx));
    }
}
