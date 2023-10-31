package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListNotSortedException extends RuntimeException{
    public IntegerListNotSortedException(String message) {
        super(message);
        System.out.println(message);
    }
}
