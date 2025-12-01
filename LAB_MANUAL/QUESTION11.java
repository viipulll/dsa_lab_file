public class QUESTION11 {

    // ---------------------- BUBBLE SORT -------------------------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break; // Already sorted
        }
    }

    // ---------------------- SELECTION SORT -------------------------
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // ---------------------- INSERTION SORT -------------------------
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }


    // ---------------------- PRINT ARRAY -------------------------
    public static void printArray(String msg, int[] arr) {
        System.out.print(msg + ": ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }


    // ---------------------- MAIN -------------------------
    public static void main(String[] args) {

        int[] arr1 = {5, 2, 9, 1, 5, 6};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        System.out.println("Original Array:");
        printArray("Array", arr1);

        bubbleSort(arr1);
        printArray("Bubble Sorted", arr1);

        selectionSort(arr2);
        printArray("Selection Sorted", arr2);

        insertionSort(arr3);
        printArray("Insertion Sorted", arr3);
    }
}
