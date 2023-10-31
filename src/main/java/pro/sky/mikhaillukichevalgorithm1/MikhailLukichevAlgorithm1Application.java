package pro.sky.mikhaillukichevalgorithm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class MikhailLukichevAlgorithm1Application {

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
		System.out.println(integerList.print());

        integerList.sortAsc();
		System.out.println(integerList.print());

        System.out.println(integerList.binaryContains(4));


    }

}
