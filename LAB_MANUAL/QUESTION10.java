public class QUESTION10 {

    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid; 
            }
            if (key < arr[mid]) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return -1; 
    }

    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int left, int right, int key) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (key < arr[mid]) {
            return binarySearchRecursive(arr, left, mid - 1, key);
        } else {
            return binarySearchRecursive(arr, mid + 1, right, key);
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 7, 10, 15, 20, 25, 30};
        int key = 15;

        System.out.println("Iterative Binary Search:");
        int idx1 = binarySearchIterative(arr, key);
        System.out.println("Element " + key + " found at index: " + idx1);

        System.out.println("\nRecursive Binary Search:");
        int idx2 = binarySearchRecursive(arr, 0, arr.length - 1, key);
        System.out.println("Element " + key + " found at index: " + idx2);
    }
}
