package ie.gmit.hdip;

import java.util.Arrays;

public class New {
	/* Bubble Sort Code */
	public static void sort_bubble(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				// If array element ([J]) is greater than its adjacent element ([J+1]) //
				if (arr[j] > arr[j + 1]) {
					// Create temporary array and use it to swap said elements ([J]) and ([J+1]) //
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	/* Merge Sort Code */
	// Contains two functions //
	// First function that partitions the array into two sub arrays and merges these
	// subarrays //
	// First subarray is arr[l..m] //
	// Second subarray is arr[m+1..r] //
	public static void merge(int arr[], int l, int m, int r) {
		// Find sizes of the two sub-arrays to be merged //
		int n1 = m - l + 1;
		int n2 = r - m;
		// Create temporary arrays //
		int L[] = new int[n1];
		int R[] = new int[n2];
		// Populate temporary arrays //
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		// Merge the temporary arrays //
		// Initial indexes of first and second sub-arrays //
		int i = 0, j = 0;
		// Initial index of merged sub-array //
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		// If there are any remaining elements in L[], copy them in //
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		// If there are any remaining elements in R[], copy them in //
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Second function that sorts arr[l..r] using the above merge() function //
	public static void sort_merge(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point //
			int m = l + (r - l) / 2;
			// Sort the first and second halves //
			sort_merge(arr, l, m);
			sort_merge(arr, m + 1, r);
			// Merge the sorted halves //
			merge(arr, l, m, r);
		}
	}

	/* Count Sort Code */
	public static void sort_count(int[] arr) {
		// Create count and output arrays to store the count of each element //
		// Arrays.stream finds the largest and smallest elements of the array //
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int count[] = new int[range];
		int output[] = new int[arr.length];
		// Initialize the count array //
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}
		// Set the count[i] to contain the correct index of this element in output array
		// //
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		// Create the output array //
		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}
		// Copy the output array to arr[], so that arr[] is now sorted. //
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	/* Gnome sort code */
	public static void sort_gnome(int arr[], int n) {
		// Initialize index at 0//
		int index = 0;
		// If at the beginning of the array, go one step to the right //
		while (index < n) {
			if (index == 0)
				index++;
			// if the current index is greater than the previous index, go one step to the
			// right //
			if (arr[index] >= arr[index - 1])
				index++;
			// if the current index is not greater than the previous index, swap those
			// indexes using a temporary array then go back one step to the left and repeat
			// the process //
			else {
				int temp = 0;
				temp = arr[index];
				arr[index] = arr[index - 1];
				arr[index - 1] = temp;
				index--;
			}
		}
		return;
	}

	public static void sort_stooge(int[] L) {
		sort_stooge(L, 0, L.length - 1);
	}

	public static void sort_stooge(int[] L, int i, int j) {
		if (L[j] < L[i]) {
			int tmp = L[i];
			L[i] = L[j];
			L[j] = tmp;
		}
		if (j - i > 1) {
			int t = (j - i + 1) / 3;
			sort_stooge(L, i, j - t);
			sort_stooge(L, i + t, j);
			sort_stooge(L, i, j - t);
		}
	}

	/* Code to generate an array of random numbers */
	public static int[] randomArray(int n) {
		// Create an array of size n //
		int[] array = new int[n];
		// Fill each index of the array with a randomly generated number between 1 and
		// 100 //
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	/* Code to benchmark the sorting algorithms */
	public static double benchmark(String sort, int[] arr) {
		// Record the system time as the function starts in nanoseconds //
		// Switch statements to call the sorting algorithms //
		long start = System.nanoTime();
		switch (sort) {
		case "sort_bubble":
			sort_bubble(arr);
			break;
		case "sort_merge":
			sort_merge(arr, 0, arr.length - 1);
			break;
		case "sort_count":
			sort_count(arr);
			break;
		case "sort_gnome":
			sort_gnome(arr, arr.length);
			break;
		case "sort_stooge":
			sort_stooge(arr, 0, arr.length - 1);
			break;
		default:
			break;
		}
		// record the system time as the function ends in nanoseconds //
		// record the time taken for the function to complete by subtracting the start
		// time from the end time //
		long end = System.nanoTime();
		long elapsed = end - start;
		double time = elapsed / 1000000.0;
		return time;
	}

	public static void main(String[] args) {
		double samplesize = 10.0f;
		// declare an array of different sample sizes for the sorting algorithms to work
		// on, and a string for the output table //
		int sizes[] = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
		String sorts[] = { "sort_bubble", "sort_merge", "sort_count", "sort_gnome", "sort_stooge" };
		// format output table neatly and print sizes output
		System.out.format("%-15s", "Size");
		for (int s = 0; s < sizes.length; s++) {
			System.out.format("%-11s", sizes[s]);
		}
		System.out.println();
		// format sizes table neatly and print the results of sorting algorithms against
		// each sample size.
		// sorting algorithms run 10 times on each sample size and an average time is
		// calculated. Average time is printed to output table against each sample size.
		for (int i = 0; i < sorts.length; i++) {
			System.out.format("%-15s", sorts[i]);
			for (int j = 0; j < sizes.length; j++) {
				double runtime = 0.0f;
				for (int n = 0; n < samplesize; n++) {
					runtime += benchmark(sorts[i], randomArray(sizes[j]));
				}
				double avg = runtime / samplesize;
				System.out.format("%-11s", (String.format("%.3f", avg)));
			}
			System.out.println();
		}
	}
}
