package pro.sky.mikhaillukichevalgorithm1;

import org.junit.jupiter.api.Test;
import pro.sky.mikhaillukichevalgorithm1.exception.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private final StringList stringList = new StringListImpl(5);

    @Test
    void print() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String[] expectedResultArray = {"0", "1", "2", "3", "4"};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualResult = stringList.print();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void findLastNotNullElementIndex() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        //Expected result
        int expectedResult = 3;

        //Test action
        int actualResult = stringList.findLastNotNullElementIndex();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addItem_success() {
        //Data preparation

        //Expected result
        String expectedString = "0";
        String[] expectedResultArray = {"0", null, null, null, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualString = stringList.add("0");
        String actualResult = stringList.print();
        assertEquals(expectedString, actualString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addItem_withStringListIsFullException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String expectedMessage = "StringList is full. Cannot add more elements.";

        //Test action
        Exception exception = assertThrows(StringListIsFullException.class,
                () -> stringList.add("5")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addItem_withStringListIllegalArgumentException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.add(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addIndexItem_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        //Expected result
        String expectedString = "Two";
        String[] expectedResultArray = {"0", "1", "Two", "2", "3"};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualString = stringList.add(2, "Two");
        String actualResult = stringList.print();
        assertEquals(expectedString, actualString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addIndexItem_withStringListIsFullException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String expectedMessage = "StringList is full. Cannot add more elements.";

        //Test action
        Exception exception = assertThrows(StringListIsFullException.class,
                () -> stringList.add(1, "5")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addIndexItem_withStringListIndexOutOfBoundsException_actualSize() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Index is out of actual (not null) StringList size.";

        //Test action
        Exception exception = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.add(3, "5")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addIndexItem_withStringListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of StringList bounds.";

        //Test action
        Exception exception1 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.add(-5, "5")
        );
        Exception exception2 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.add(10, "5")
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void addIndexItem_withStringListIllegalArgumentException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.add(0,null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void set_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedString = "One";
        String[] expectedResultArray = {"0", "One", null, null, null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualString = stringList.set(1, "One");
        String actualResult = stringList.print();
        assertEquals(expectedString, actualString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void set_withStringListIndexOutOfBoundsException_actualSize() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Index is out of actual (not null) StringList size.";

        //Test action
        Exception exception = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.set(3, "3")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void set_withStringListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of StringList bounds.";

        //Test action
        Exception exception1 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.set(-5, "5")
        );
        Exception exception2 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.set(10, "5")
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void set_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.set(0,null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeItem_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String expectedString = "2";
        String[] expectedResultArray = {"0", "1", "3", "4", null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualString = stringList.remove("2");
        String actualResult = stringList.print();
        assertEquals(expectedString, actualString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeItem_withStringListElementIsNotFoundException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Element is not found.";

        //Test action
        Exception exception = assertThrows(StringListElementIsNotFoundException.class,
                () -> stringList.remove("3")
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeItem_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.remove(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeIndex_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String expectedString = "2";
        String[] expectedResultArray = {"0", "1", "3", "4", null};
        String expectedResult = Arrays.toString(expectedResultArray);

        //Test action
        String actualString = stringList.remove(2);
        String actualResult = stringList.print();
        assertEquals(expectedString, actualString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeIndex_withStringListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of StringList bounds.";

        //Test action
        Exception exception1 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.remove(-5)
        );
        Exception exception2 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.remove(10)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void removeIndex_withStringListElementIsNullException() {
        //Data preparation

        //Expected result
        String expectedMessage = "Element is null.";

        //Test action
        Exception exception1 = assertThrows(StringListElementIsNullException.class,
                () -> stringList.remove(0)
        );
        assertEquals(expectedMessage, exception1.getMessage());
    }

    @Test
    void contains_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        boolean expectedTrue = true;
        boolean expectedFalse = false;

        //Test action
        boolean actualTrue = stringList.contains("0");
        boolean actualFalse = stringList.contains("5");
        assertEquals(expectedTrue,actualTrue);
        assertEquals(expectedFalse,actualFalse);
    }

    @Test
    void contains_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.contains(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void indexOf() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("2");
        stringList.add("2");

        //Expected result
        int expectedResultFound = 2;
        int expectedResultNotFound = -1;

        //Test action
        int actualResultFound = stringList.indexOf("2");
        int actualResultNotFound = stringList.indexOf("5");
        assertEquals(expectedResultFound,actualResultFound);
        assertEquals(expectedResultNotFound,actualResultNotFound);
    }

    @Test
    void indexOf_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.indexOf(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void lastIndexOf() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("2");
        stringList.add("2");

        //Expected result
        int expectedResultFound = 4;
        int expectedResultNotFound = -1;

        //Test action
        int actualResultFound = stringList.lastIndexOf("2");
        int actualResultNotFound = stringList.lastIndexOf("5");
        assertEquals(expectedResultFound,actualResultFound);
        assertEquals(expectedResultNotFound,actualResultNotFound);
    }

    @Test
    void lastIndexOf_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.lastIndexOf(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void get_success() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String expectedResult = "2";

        //Test action
        String actualResult = stringList.get(2);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void get_withStringListIndexOutOfBoundsException_outOfBounds() {
        //Data preparation

        //Expected result
        String expectedMessage = "Index is out of StringList bounds.";

        //Test action
        Exception exception1 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.get(-5)
        );
        Exception exception2 = assertThrows(StringListIndexOutOfBoundsException.class,
                () -> stringList.get(10)
        );
        assertEquals(expectedMessage, exception1.getMessage());
        assertEquals(expectedMessage, exception2.getMessage());
    }

    @Test
    void equals() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        StringList comparisonStringListTrue = new StringListImpl(5);
        comparisonStringListTrue.add("0");
        comparisonStringListTrue.add("1");
        comparisonStringListTrue.add("2");
        comparisonStringListTrue.add("3");
        comparisonStringListTrue.add("4");

        StringList comparisonStringListFalse = new StringListImpl(5);
        comparisonStringListFalse.add("0");
        comparisonStringListFalse.add("1");
        comparisonStringListFalse.add("2");
        comparisonStringListFalse.add("3");

        //Expected result
        boolean expectedResultTrue = true;
        boolean expectedResultFalse = false;

        //Test action
        boolean actualResultTrue = stringList.equals(comparisonStringListTrue);
        assertEquals(expectedResultTrue,actualResultTrue);

        boolean actualResultFalse = stringList.equals(comparisonStringListFalse);
        assertEquals(expectedResultFalse,actualResultFalse);
    }

    @Test
    void equals_withStringListIllegalArgumentException() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");

        //Expected result
        String expectedMessage = "Argument cannot be null.";

        //Test action
        Exception exception = assertThrows(StringListIllegalArgumentException.class,
                () -> stringList.equals(null)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void size() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        int expectedResult = 5;

        //Test action
        int actualResult = stringList.size();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void isEmpty_true() {
        //Data preparation

        //Expected result
        boolean expectedResult = true;

        //Test action
        boolean actualResult = stringList.isEmpty();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void isEmpty_false() {
        //Data preparation
        stringList.add("0");

        //Expected result
        boolean expectedResult = false;

        //Test action
        boolean actualResult = stringList.isEmpty();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void clear() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        boolean expectedResult = true;

        //Test action
        stringList.clear();
        boolean actualResult = stringList.isEmpty();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void toArray() {
        //Data preparation
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        //Expected result
        String[] expectedResult = {"0","1","2","3","4"};

        //Test action
        String[] actualResult = stringList.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }
}