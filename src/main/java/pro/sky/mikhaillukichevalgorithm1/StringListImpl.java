package pro.sky.mikhaillukichevalgorithm1;

import pro.sky.mikhaillukichevalgorithm1.exception.*;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] stringList;

    public StringListImpl(int size) {
        this.stringList = new String[size];
    }

    public String print() {
        return Arrays.toString(stringList);
    }

    public int findLastNotNullElementIndex() {
        int lastNotEmpty = -1;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] != null) lastNotEmpty = i;
        }
        return lastNotEmpty;
    }

    public String add(String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //if StringList is full, throw an exception
        if (this.size() == stringList.length ) throw new StringListIsFullException("StringList is full. Cannot add more elements.");

        int i = 0;
        while (i < stringList.length) {
            if (stringList[i] == null) {
                stringList[i] = item;
                break;
            }
            i++;
        }
        return item;
    }

    public String add(int index, String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //find last not empty element
        int lastNotEmptyIndex = findLastNotNullElementIndex();

        //if last not empty element is the last in the array, throw exception (elements cannot be moved right without data loss)
        if (lastNotEmptyIndex == stringList.length - 1) throw new StringListIsFullException("StringList is full. Cannot add more elements.");

        //if index is out of the array size, throw an exception
        if (index >= stringList.length || index < 0) throw new StringListIndexOutOfBoundsException("Index is out of StringList bounds.");

        //if index is out of last not empty element index, throw an exception
        if (index > lastNotEmptyIndex + 1) throw new StringListIndexOutOfBoundsException("Index is out of actual (not null) StringList size.");

        //move not empty elements to the right of the index
        for (int i = lastNotEmptyIndex; i >= index; i--) {
            stringList[i + 1] = stringList[i];
        }

        //insert new item at the index position
        stringList[index] = item;

        return item;
    }

    public String set(int index, String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //find last not empty element
        int lastNotEmptyIndex = findLastNotNullElementIndex();

        //if index is out of the array size, throw an exception
        if (index >= stringList.length || index < 0) throw new StringListIndexOutOfBoundsException("Index is out of StringList bounds.");

        //if index is out of last not empty element index, throw an exception
        if (index > lastNotEmptyIndex) throw new StringListIndexOutOfBoundsException("Index is out of actual (not null) StringList size.");

        //set the item at the index position
        stringList[index] = item;

        return item;
    }

    public String remove(String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //throw an exception if item is not in the array
        if (!this.contains(item)) throw new StringListElementIsNotFoundException("Element is not found.");

        //find the indexes
        int itemIndex = this.indexOf(item);
        int lastNotNullIndex = this.findLastNotNullElementIndex();

        //shift all not empty elements by one index
        for (int i = itemIndex; i < lastNotNullIndex; i++) {
            stringList[i] = stringList[i + 1];
        }
        //set the last element as null
        stringList[lastNotNullIndex] = null;

        return item;
    }

    public String remove(int index) {
        //if index is out of the array size, throw an exception
        if (index >= stringList.length || index < 0) throw new StringListIndexOutOfBoundsException("Index is out of StringList bounds.");

        //if index element is null, throw an exception
        if (stringList[index] == null) throw new StringListElementIsNullException("Element is null.");

        String returnElement = stringList[index];

        //find an index of the last not null element
        int lastNotNullIndex = this.findLastNotNullElementIndex();

        //shift all not empty elements by one index
        for (int i = index; i < lastNotNullIndex; i++) {
            stringList[i] = stringList[i + 1];
        }
        //set the last element as null
        stringList[lastNotNullIndex] = null;

        return returnElement;
    }

    public boolean contains(String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        for (String s : stringList) {
            if (Objects.equals(s, item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //return -1 if item is not in the array
        if (!this.contains(item)) return -1;

        //find the item index
        int itemIndex = -1;
        for (int i = 0; i < stringList.length; i++) {
            if (Objects.equals(stringList[i], item)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public int lastIndexOf(String item) {
        //if argument is null, throw an exception
        if (item == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        //return -1 if item is not in the array
        if (!this.contains(item)) return -1;

        //find the item index
        int itemIndex = -1;
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (Objects.equals(stringList[i], item)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public String get(int index) {
        //if index is out of the array size, throw an exception
        if (index >= stringList.length || index < 0) throw new StringListIndexOutOfBoundsException("Index is out of StringList bounds.");
        return stringList[index];
    }

    public boolean equals(StringList otherList) {
        //if argument is null, throw an exception
        if (otherList == null) throw new StringListIllegalArgumentException("Argument cannot be null.");

        String[] compareArray = otherList.toArray();
        return Arrays.equals(stringList,compareArray);
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
            stringList[i] = null;
        }
    }

    public String[] toArray() {
        if (this.isEmpty()) return null;
        int lastNotNullIndex = this.findLastNotNullElementIndex();
        return Arrays.copyOfRange(stringList, 0, lastNotNullIndex + 1);
    }
}
