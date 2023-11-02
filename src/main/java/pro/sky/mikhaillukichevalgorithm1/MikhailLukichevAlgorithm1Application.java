package pro.sky.mikhaillukichevalgorithm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class MikhailLukichevAlgorithm1Application {
    public static void main(String[] args) {
//		SpringApplication.run(MikhailLukichevAlgorithm1Application.class, args);

//        sortComparison();

//		StringList stringList = new StringListImpl(5);
//
//		stringList.add("0");
//		stringList.add("1");
//		stringList.add("2");
//		stringList.add("3");
//		stringList.add("4");
//		System.out.println(stringList.print());
//
        IntegerList integerList = new IntegerListImpl(5);
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(5);
        System.out.println(integerList.print());

        integerList.add(2, 9);
        System.out.println(integerList.print());

        integerList.sortAsc();
        System.out.println(integerList.print());
    }


    private static Integer[] generateRandomArray(int size) {
        Random rd = new Random(); // creating Random object
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        return arr;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    //quick sort
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    //merge sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

    public static void sortComparison() {
        Integer[] initialArray = generateRandomArray(20000);
        Integer[] array1 = Arrays.copyOf(initialArray, initialArray.length);
        Integer[] array2 = Arrays.copyOf(initialArray, initialArray.length);
        Integer[] array3 = Arrays.copyOf(initialArray, initialArray.length);

        //measure bubble sorting
        long start = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println("Bubble sort time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortSelection(array2);
        System.out.println("Selection sort time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println("Insertions sort time: " + (System.currentTimeMillis() - start));
    }



}
