package strategy;

interface SortingStrategy {
	void sort(int[] list);
}

class BubbleSort implements SortingStrategy {

	@Override
	public void sort(int[] list) {
		System.out.println("Sorted by BubbleSort");
		bubbleSort(list, list.length);
	}
	
	private void bubbleSort(int arr[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
}
class QuickSort implements SortingStrategy {

	@Override
	public void sort(int[] list) {
		System.out.println("Sorted by QuickSort");
		quickSort(list, 0, list.length-1);
	}
	
    private static int partition(int[] arr, int low, int high) {
        
        // Choose the pivot
        int pivot = arr[high];
        
        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }

    // Swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The QuickSort function implementation
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
class MergeSort implements SortingStrategy {

	@Override
	public void sort(int[] list) {
		System.out.println("Sorted by MergeSort");
		sort(list, 0, list.length-1);
	}
	private static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
}

class Sorter {
	private SortingStrategy sortingStrategy;
	
	public void setSortingStrategy(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}
	
	public void sortArray(int[] array) {
		System.out.print("\nBefore: ");
		printArray(array, array.length);
		sortingStrategy.sort(array);
		System.out.print("After: ");
		printArray(array, array.length);
	}
	private void printArray(int arr[], int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}


public class MainSorter {

	public static void main(String[] args) {
		Sorter sorter = new Sorter();

		// Use BubbleSort
		sorter.setSortingStrategy(new BubbleSort());
		sorter.sortArray(new int[]{5, 2, 9, 1, 5, 6});

		// Use QuickSort
		sorter.setSortingStrategy(new QuickSort());
		sorter.sortArray(new int[]{8, 3, 7, 4, 2});

		// Use MergeSort
		sorter.setSortingStrategy(new MergeSort());
		sorter.sortArray(new int[]{10, 50, 20, 30, 40});

	}

}
