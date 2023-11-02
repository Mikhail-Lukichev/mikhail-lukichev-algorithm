package pro.sky.mikhaillukichevalgorithm1;

import pro.sky.mikhaillukichevalgorithm1.exception.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IntegerListImpl implements IntegerList{


    private final Integer[] integerList;

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    public String print() {
        return Arrays.toString(integerList);
    }

    public int findLastNotNullElementIndex() {
        int lastNotEmpty = -1;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) lastNotEmpty = i;
        }
        return lastNotEmpty;
    }

    public Integer add(Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //if IntegerList is full, throw an exception
        if (this.size() == integerList.length ) throw new IntegerListIsFullException("IntegerList is full. Cannot add more elements.");

        int i = 0;
        while (i < integerList.length) {
            if (integerList[i] == null) {
                integerList[i] = item;
                break;
            }
            i++;
        }
        return item;
    }

    public Integer add(int index, Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //find last not empty element
        int lastNotEmptyIndex = findLastNotNullElementIndex();

        //if last not empty element is the last in the array, throw exception (elements cannot be moved right without data loss)
        if (lastNotEmptyIndex == integerList.length - 1) throw new IntegerListIsFullException("IntegerList is full. Cannot add more elements.");

        //if index is out of the array size, throw an exception
        if (index >= integerList.length || index < 0) throw new IntegerListIndexOutOfBoundsException("Index is out of IntegerList bounds.");

        //if index is out of last not empty element index, throw an exception
        if (index > lastNotEmptyIndex + 1) throw new IntegerListIndexOutOfBoundsException("Index is out of actual (not null) IntegerList size.");

        //move not empty elements to the right of the index
        for (int i = lastNotEmptyIndex; i >= index; i--) {
            integerList[i + 1] = integerList[i];
        }

        //insert new item at the index position
        integerList[index] = item;

        return item;
    }

    public Integer set(int index, Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //find last not empty element
        int lastNotEmptyIndex = findLastNotNullElementIndex();

        //if index is out of the array size, throw an exception
        if (index >= integerList.length || index < 0) throw new IntegerListIndexOutOfBoundsException("Index is out of IntegerList bounds.");

        //if index is out of last not empty element index, throw an exception
        if (index > lastNotEmptyIndex) throw new IntegerListIndexOutOfBoundsException("Index is out of actual (not null) IntegerList size.");

        //set the item at the index position
        integerList[index] = item;

        return item;
    }

    public Integer remove(Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //throw an exception if item is not in the array
        if (!this.contains(item)) throw new IntegerListElementIsNotFoundException("Element is not found.");

        //find the indexes
        int itemIndex = this.indexOf(item);
        int lastNotNullIndex = this.findLastNotNullElementIndex();

        //shift all not empty elements by one index
        for (int i = itemIndex; i < lastNotNullIndex; i++) {
            integerList[i] = integerList[i + 1];
        }
        //set the last element as null
        integerList[lastNotNullIndex] = null;

        return item;
    }

    public Integer remove(int index) {
        //if index is out of the array size, throw an exception
        if (index >= integerList.length || index < 0) throw new IntegerListIndexOutOfBoundsException("Index is out of IntegerList bounds.");

        //if index element is null, throw an exception
        if (integerList[index] == null) throw new IntegerListElementIsNullException("Element is null.");

        Integer returnElement = integerList[index];

        //find an index of the last not null element
        int lastNotNullIndex = this.findLastNotNullElementIndex();

        //shift all not empty elements by one index
        for (int i = index; i < lastNotNullIndex; i++) {
            integerList[i] = integerList[i + 1];
        }
        //set the last element as null
        integerList[lastNotNullIndex] = null;

        return returnElement;
    }

    public boolean contains(Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        for (Integer s : integerList) {
            if (Objects.equals(s, item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //return -1 if item is not in the array
        if (!this.contains(item)) return -1;

        //find the item index
        int itemIndex = -1;
        for (int i = 0; i < integerList.length; i++) {
            if (Objects.equals(integerList[i], item)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public int lastIndexOf(Integer item) {
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        //return -1 if item is not in the array
        if (!this.contains(item)) return -1;

        //find the item index
        int itemIndex = -1;
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (Objects.equals(integerList[i], item)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public Integer get(int index) {
        //if index is out of the array size, throw an exception
        if (index >= integerList.length || index < 0) throw new IntegerListIndexOutOfBoundsException("Index is out of IntegerList bounds.");
        return integerList[index];
    }

    public boolean equals(IntegerList otherList) {
        //if argument is null, throw an exception
        if (otherList == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        Integer[] compareArray = otherList.toArray();
        return Arrays.equals(integerList,compareArray);
    }

    public int size() {
        return this.findLastNotNullElementIndex() + 1;
    }

    public boolean isEmpty() {
        return this.findLastNotNullElementIndex() == -1;
    }

    public void clear() {
        int lastNotNullIndex = this.findLastNotNullElementIndex();
        for (int i = 0; i <= lastNotNullIndex; i++) {
            integerList[i] = null;
        }
    }

    public Integer[] toArray() {
        if (this.isEmpty()) return null;
        int lastNotNullIndex = this.findLastNotNullElementIndex();
        return Arrays.copyOfRange(integerList, 0, lastNotNullIndex + 1);
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public void sortAsc(){
        int max = this.findLastNotNullElementIndex();
        for (int i = 0; i < max; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j <= max; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
    }

    public boolean binaryContains(Integer item){
        //if argument is null, throw an exception
        if (item == null) throw new IntegerListIllegalArgumentException("Argument cannot be null.");

        int max = this.findLastNotNullElementIndex();

        //check if IntegerList is sorted. If not, throw an Exception
        for (int i = 0; i < max - 1; i++) {
            if (integerList[i+1] < integerList[i]) throw new IntegerListNotSortedException("IntegerList is not sorted. binaryContains cannot be used.");
        }

        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(integerList[mid])) {
                return true;
            }

            if (item < integerList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
