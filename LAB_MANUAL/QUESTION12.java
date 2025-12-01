public class QUESTION12 {

    // ---------------------- QUICK SORT -------------------------
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    // ---------------------- MERGE SORT -------------------------
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }


    // ---------------------- HEAP SORT -------------------------
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // extract elements
        for (int i = n - 1; i >= 0; i--) {

            // move max to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int size, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, size, largest);
        }
    }


    // ---------------------- PRINT ARRAY -------------------------
    public static void printArray(String msg, int[] arr) {
        System.out.print(msg + ": ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }


    // ---------------------- MAIN -------------------------
    public static void main(String[] args) {

        int[] arr1 = {9, 3, 7, 1, 5, 4, 9};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        printArray("Original", arr1);

        quickSort(arr1, 0, arr1.length - 1);
        printArray("Quick Sort", arr1);

        mergeSort(arr2, 0, arr2.length - 1);
        printArray("Merge Sort", arr2);

        heapSort(arr3);
        printArray("Heap Sort", arr3);
    }
}
