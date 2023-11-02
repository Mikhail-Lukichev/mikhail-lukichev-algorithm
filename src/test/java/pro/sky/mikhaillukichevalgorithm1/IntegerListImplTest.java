package pro.sky.mikhaillukichevalgorithm1;

import org.junit.jupiter.api.Test;
import pro.sky.mikhaillukichevalgorithm1.exception.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private final IntegerList integerList = new IntegerListImpl(5);

    @Test
    void print() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer[] expectedResultArray = {0, 1, 2, 3, 4};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualResult = integerList.print();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void findLastNotNullElementIndex() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        //Expected result
        int expectedResult = 3;

        //Test action
        int actualResult = integerList.findLastNotNullElementIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addItem_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer expectedInteger = 5;
        Integer[] expectedResultArray = {0, 1, 2, 3, 4, 5, null, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        Integer actualInteger = integerList.add(5);
        String actualResult = integerList.print();
        assertEquals(expectedInteger, actualInteger);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addItem_withIntegerListIllegalArgumentException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.add(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addIndexItem_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer expectedInteger = 9;
        Integer[] expectedResultArray = {0, 1, 9, 2, 3, 4, null, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        Integer actualInteger = integerList.add(2, 9);
        String actualResult = integerList.print();
        assertEquals(expectedInteger, actualInteger);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void addIndexItem_withIntegerListIndexOutOfBoundsException_actualSize() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Index is out of actual (not null) IntegerList size.";

        //Test action
        Exception exception = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.add(3, 5)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addIndexItem_withIntegerListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of IntegerList bounds.";

        //Test action
        Exception exception1 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.add(-5, 5)
        );
        Exception exception2 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.add(10, 5)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void addIndexItem_withIntegerListIllegalArgumentException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.add(0, null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void set_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        Integer expectedInteger = 1;
        Integer[] expectedResultArray = {0, 1, null, null, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        Integer actualInteger = integerList.set(1, 1);
        String actualResult = integerList.print();
        assertEquals(expectedInteger, actualInteger);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void set_withIntegerListIndexOutOfBoundsException_actualSize() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Index is out of actual (not null) IntegerList size.";

        //Test action
        Exception exception = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.set(3, 3)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void set_withIntegerListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of IntegerList bounds.";

        //Test action
        Exception exception1 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.set(-5, 5)
        );
        Exception exception2 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.set(10, 5)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void set_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.set(0, null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeItem_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer expectedInteger = 2;
        Integer[] expectedResultArray = {0, 1, 3, 4, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        Integer actualInteger = integerList.remove((Integer) 2);
        String actualResult = integerList.print();
        assertEquals(expectedInteger, actualInteger);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeItem_withIntegerListElementIsNotFoundException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Element is not found.";

        //Test action
        Exception exception = assertThrows(IntegerListElementIsNotFoundException.class,
                () -> integerList.remove((Integer) 3)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeItem_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.remove(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeIndex_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer expectedInteger = 2;
        Integer[] expectedResultArray = {0, 1, 3, 4, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        Integer actualInteger = integerList.remove((int) 2);
        String actualResult = integerList.print();
        assertEquals(expectedInteger, actualInteger);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeIndex_withIntegerListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of IntegerList bounds.";

        //Test action
        Exception exception1 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.remove((int) -5)
        );
        Exception exception2 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.remove((int) 10)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void removeIndex_withIntegerListElementIsNullException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Element is null.";

        //Test action
        Exception exception1 = assertThrows(IntegerListElementIsNullException.class,
                () -> integerList.remove((int) 0)
        );
        assertEquals(expectedMessage, exception1.getMessage());
    }

    @Test
    void contains_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        boolean expectedTrue = true;
        boolean expectedFalse = false;

        //Test action
        boolean actualTrue = integerList.contains(0);
        boolean actualFalse = integerList.contains(5);
        assertEquals(expectedTrue, actualTrue);
        assertEquals(expectedFalse, actualFalse);
    }

    @Test
    void contains_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.contains(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void indexOf() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);

        //Expected result
        int expectedResultFound = 2;
        int expectedResultNotFound = -1;

        //Test action
        int actualResultFound = integerList.indexOf(2);
        int actualResultNotFound = integerList.indexOf(5);
        assertEquals(expectedResultFound, actualResultFound);
        assertEquals(expectedResultNotFound, actualResultNotFound);
    }

    @Test
    void indexOf_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.indexOf(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void lastIndexOf() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);

        //Expected result
        int expectedResultFound = 4;
        int expectedResultNotFound = -1;

        //Test action
        int actualResultFound = integerList.lastIndexOf(2);
        int actualResultNotFound = integerList.lastIndexOf(5);
        assertEquals(expectedResultFound, actualResultFound);
        assertEquals(expectedResultNotFound, actualResultNotFound);
    }

    @Test
    void lastIndexOf_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.lastIndexOf(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void get_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer expectedResult = 2;

        //Test action
        Integer actualResult = integerList.get(2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void get_withIntegerListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of IntegerList bounds.";

        //Test action
        Exception exception1 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.get(-5)
        );
        Exception exception2 = assertThrows(IntegerListIndexOutOfBoundsException.class,
                () -> integerList.get(10)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void equals() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        IntegerList comparisonIntegerListTrue = new IntegerListImpl(5);
        comparisonIntegerListTrue.add(0);
        comparisonIntegerListTrue.add(1);
        comparisonIntegerListTrue.add(2);
        comparisonIntegerListTrue.add(3);
        comparisonIntegerListTrue.add(4);

        IntegerList comparisonIntegerListFalse = new IntegerListImpl(5);
        comparisonIntegerListFalse.add(0);
        comparisonIntegerListFalse.add(1);
        comparisonIntegerListFalse.add(2);
        comparisonIntegerListFalse.add(3);

        //Expected result
        boolean expectedResultTrue = true;
        boolean expectedResultFalse = false;

        //Test action
        boolean actualResultTrue = integerList.equals(comparisonIntegerListTrue);
        assertEquals(expectedResultTrue, actualResultTrue);

        boolean actualResultFalse = integerList.equals(comparisonIntegerListFalse);
        assertEquals(expectedResultFalse, actualResultFalse);
    }

    @Test
    void equals_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.equals(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void size() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        int expectedResult = 5;

        //Test action
        int actualResult = integerList.size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isEmpty_true() {
        //Data preparation

        //Expected result
        boolean expectedResult = true;

        //Test action
        boolean actualResult = integerList.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isEmpty_false() {
        //Data preparation
        integerList.add(0);

        //Expected result
        boolean expectedResult = false;

        //Test action
        boolean actualResult = integerList.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void clear() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        boolean expectedResult = true;

        //Test action
        integerList.clear();
        boolean actualResult = integerList.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void toArray() {
        //Data preparation
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Expected result
        Integer[] expectedResult = {0, 1, 2, 3, 4};

        //Test action
        Integer[] actualResult = integerList.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void sortAsc() {
        //Data preparation
        integerList.add(0);
        integerList.add(4);
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        //Expected result
        Integer[] expectedResult = {0, 1, 2, 3, 4};

        //Test action
        integerList.sortAsc();
        Integer[] actualResult = integerList.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void binaryContains_success() {
        //Data preparation
        integerList.add(0);
        integerList.add(4);
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        //Expected result
        boolean expectedResultTrue = true;
        boolean expectedResultFalse = false;

        //Test action
        integerList.sortAsc();
        boolean actualResultTrue = integerList.binaryContains(4);
        boolean actualResultFalse = integerList.binaryContains(8);
        assertEquals(expectedResultTrue, actualResultTrue);
        assertEquals(expectedResultFalse, actualResultFalse);
    }

    @Test
    void binaryContains_withIntegerListNotSortedException() {
        //Data preparation
        integerList.add(0);
        integerList.add(4);
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        //Expected result
        String expectedMessage = "IntegerList is not sorted. binaryContains cannot be used.";

        //Test action
        Exception exception = assertThrows(IntegerListNotSortedException.class,
                () -> integerList.binaryContains(4)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void binaryContains_withIntegerListIllegalArgumentException() {
        //Data preparation
        integerList.add(0);
        integerList.add(4);
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(IntegerListIllegalArgumentException.class,
                () -> integerList.binaryContains(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
}